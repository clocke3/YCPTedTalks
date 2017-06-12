package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Word;


public class DerbyDatabase implements IDatabase{
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;


	// wrapper SQL transaction function that calls actual transaction function
	// (which has retries)
	public <ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	// SQL transaction function which retries the transaction MAX_ATTEMPTS times
	// before failing
	public <ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been
						// reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}
	///where the real action begins 
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby: Users/chihealocke/Personal Work/library.db;create=true");

		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}

	private void loadWord(Word word, ResultSet resultSet, int index) throws SQLException {
		word.setWordId(resultSet.getInt(index++));
		word.setWord(resultSet.getString(index++));
	}

	//create word table 
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@SuppressWarnings("resource")
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;

				try {
					// Create accounts table
					stmt1 = conn.prepareStatement("create table three_words (" + "	account_id integer primary key"
							+ " 		generated always as identity (start with 1, increment by 1),"
							+ "	word varchar(10)" + ")");

					stmt1.executeUpdate();
					System.out.println("Word table created!");

					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
				}
			}
		});
	}
	//loads data from word table
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			public Boolean execute(Connection conn) throws SQLException {
				List<Word> wordList;

				try {
					wordList = InitialData.getWords();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertWords = null;

				try {
					// Insert the accounts into the accounts table
					insertWords = conn.prepareStatement(
							"insert into three_words (word) values (?)");
					for (Word word: wordList) {
						insertWords.setString(1, word.getWord().toLowerCase());
						insertWords.addBatch();
					}
					insertWords.executeBatch();
					System.out.println("Word table populated");
				
					return true;
				} finally {
					DBUtil.closeQuietly(insertWords);
				}
			}
		});
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();

		System.out.println("Loading initial data...");
		db.loadInitialData();

		System.out.println("Library DB successfully initialized!");
	}
	
	public Boolean deleteTables() {
		// Look up an account by their email
		return executeTransaction(new Transaction<Boolean>() {
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					stmt = conn.prepareStatement("drop table three_words");
					stmt.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	public Boolean insertWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
