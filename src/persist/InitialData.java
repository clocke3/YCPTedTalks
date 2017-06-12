package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Word;

public class InitialData {
	
	public static List<Word> getWords() throws IOException {
		List<Word> three_wList = new ArrayList<Word>();
		ReadCSV readWords = new ReadCSV("three_words.csv");
		
		try {
			Integer wordId = 1;
			while(true) {
				List<String> tuple = readWords.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Word word = new Word();
				
				// Throw away CSV file account id
				Integer.parseInt(i.next());
				// Auto-generate account id
				word.setWordId(wordId++);
				// Load the rest of the info from the CSV file
				word.setWord(i.next());
				three_wList.add(word);
			}
			System.out.println("Loaded words from three_words.csv");
			return three_wList;
		} finally {
			readWords.close();
		}
	}
}