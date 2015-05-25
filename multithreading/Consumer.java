package multiThreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

import database.DatabaseConnect;
import main.ILogRecordParser;
import main.LogRecord;
import main.LogRecordParser;

class Consumer implements Runnable {

	private ILogRecordParser parser;
	private static volatile PrintWriter out;
	private static volatile int count = 0;
	private final int amountOfLines;
	private BlockingQueue<String> queueLines;
	private BlockingQueue<LogRecord> queueLogs;

	Consumer(String path, int amountOfLines, BlockingQueue<String> queueLines,
			BlockingQueue<LogRecord> queueLogs) throws IOException {
		parser = new LogRecordParser();
		this.amountOfLines = amountOfLines;
		this.queueLines = queueLines;
		this.queueLogs = queueLogs;
		out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
	}

	@Override
	public void run() {

		try {
			//DatabaseConnect.connectToDatabase("D:\\logs.s3db");
			//DatabaseConnect.createDatabase();
			while (count < amountOfLines) {

				consume(queueLines.take());
			}
			out.close();
			DatabaseConnect.closeDatabase();
		} catch (InterruptedException | SQLException | ClassNotFoundException ex) {
		}
	}

	private void consume(String x) throws InterruptedException, SQLException {
		++count;
		main.LogRecord log = parser.parse(x);
		//out.println(log);
		//DatabaseConnect.writeDatabase(log);
		if (ConsumerReport.runnable) {
			queueLogs.put(log);
		}
	}
}
