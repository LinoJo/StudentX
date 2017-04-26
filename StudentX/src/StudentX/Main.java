package StudentX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main {
	private static final String JDBC_URL = "jdbc:derby:database;create=true";

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.put("user", "user");

		try (Connection connection = DriverManager.getConnection(JDBC_URL, properties)) {
			if(!Database.tableExists(connection)) Database.createTable(connection);
		}

	}

}
