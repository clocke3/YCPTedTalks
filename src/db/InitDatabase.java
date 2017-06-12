package db;

import java.util.Scanner;

import persist.DatabaseProvider;
import persist.DerbyDatabase;

public class InitDatabase {
		public void init(Scanner keyboard) {

			DatabaseProvider.setInstance(new DerbyDatabase());
		}
	}
