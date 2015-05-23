package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import main.DateFormat;
import main.InputData;
import main.LogRecord;

public class DatabaseConnect implements DateFormat {
	public static Connection connection;
	public static Statement statement;
	public static ResultSet resultSet;

	public static void connectToDatabase(String path)
			throws ClassNotFoundException, SQLException {
		connection = null;
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:" + path);

	}

	public static void createDatabase() throws ClassNotFoundException,
			SQLException {
		statement = connection.createStatement();
		statement
				.execute("CREATE TABLE if not exists 'logs' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'host' text, 'date' TIMESTAMP, 'request' text, 'replyCode' INT, 'replySize' INT);");

	}

	public static void WriteDatabase(LogRecord log, int count)
			throws SQLException {

		Timestamp sqlTimestamp = new Timestamp(log.getTimestamp().getTime());
		statement
				.execute(String
						.format("INSERT INTO 'logs' ('host', 'date', 'request', 'replyCode', 'replySize') VALUES ('%1$s', '%2$s','%3$s', %4$d, %5$d); ",
								log.getHost().toString(), sqlTimestamp,
								log.getRequest(), log.getReplyCode(),
								log.getReplySize()));
	}

	public static void ReadDatabase(String query, InputData data)
			throws ClassNotFoundException, SQLException {

		Timestamp sqlTimestamp1 = new Timestamp(data.getStartDate().getTime());
		Timestamp sqlTimestamp2 = new Timestamp(data.getEndDate().getTime());

		String fullQuery = String
				.format("select %1$s from logs where id >= '%2$s' and id < '%3$s' and date >= '%4$s' and date <= '%5$s'",
						query, data.getStartLineNumber(),
						data.getStartLineNumber() + data.getAmountOfLines(),
						sqlTimestamp1, sqlTimestamp2);

		resultSet = statement.executeQuery(fullQuery);
		while (resultSet.next()) {
			System.out.println(query + " " + resultSet.getInt(query));
		}
	}

	public static void CloseDatabase() throws ClassNotFoundException,
			SQLException {
		connection.close();
		statement.close();
		resultSet.close();
	}

}
