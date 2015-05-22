package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import main.DateFormat;
import main.LogRecord;

public class DatabaseConnect implements DateFormat {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;

	public static void connectToDatabase(String path) throws ClassNotFoundException,
			SQLException {
		conn = null;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager
				.getConnection("jdbc:sqlite:" + path);

	}

	public static void createDatabase() throws ClassNotFoundException,
			SQLException {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'logs' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'host' text, 'date' DATE, 'time' TIME, 'request' text, 'replyCode' INT, 'replySize' INT);");

	}

	public static void WriteDatabase(LogRecord log, int count)
			throws SQLException {

		java.sql.Date sqlDate = new java.sql.Date(log.getTimestamp().getTime());
		java.sql.Time sqlTime = new Time(log.getTimestamp().getTime());

		statmt.execute(String
				.format("INSERT INTO 'logs' ('host', 'date', 'time', 'request', 'replyCode', 'replySize') VALUES ('%1$s', '%2$s', '%6$s','%3$s', %4$d, %5$d); ",
						log.getHost().toString(), sqlDate, log.getRequest(),
						log.getReplyCode(), log.getReplySize(), sqlTime));
	}

	public static void ReadDatabase(String query)
			throws ClassNotFoundException, SQLException {

		String fullQuery = "select " + query + " from logs";
		resSet = statmt.executeQuery(fullQuery);
		while (resSet.next()) {
			System.out.println(query + " " + resSet.getInt(query));
		}

	}

	public static void CloseDatabase() throws ClassNotFoundException,
			SQLException {
		conn.close();
		statmt.close();
		resSet.close();
	}

}
