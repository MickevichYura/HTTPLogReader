package multiThreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

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
			while (count < amountOfLines) {

				consume(queueLines.take());
			}
			out.close();
		} catch (InterruptedException ex) {
		}

	}

	private void consume(String x) throws InterruptedException {
		++count;
		main.LogRecord log = parser.parse(x);
		queueLogs.put(log);
		out.println(log);
	}
}