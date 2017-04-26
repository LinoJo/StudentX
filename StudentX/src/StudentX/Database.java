package StudentX;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	static boolean tableExists(Connection connection) throws SQLException {
		try (ResultSet result = connection.getMetaData().getTables("%", "%", "%", new String[]{"TABLE", "SYSTEM TABLE"})) {
			while(result.next()) {
				if(result.getString("TABLE_NAME").equalsIgnoreCase("STUDENTEN")) return true;
			}
		}
		
		return false;
	}
	
	static void createTable(Connection connection) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.execute("CREATE TABLE STUDENTEN (id integer primary key generated always as identity, name varchar(64))");
		}
	}

}
