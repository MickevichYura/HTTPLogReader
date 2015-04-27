package multiThreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import main.ILogRecordParser;
import main.LogRecordParser;

class Consumer implements Runnable {

	private ILogRecordParser parser;
	private PrintWriter out;
	private int count = 0;
	
	Consumer(String path) throws IOException {
		parser = new LogRecordParser();
		out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
	}

	public void run() {

		try {
			while (count < CommonData.amountOfLines) {

				consume(CommonData.queueLines.take());
			}
			out.close();
		} catch (InterruptedException ex) {
		}

	}

	void consume(String x) throws InterruptedException {
		++count;
		main.LogRecord log = parser.parse(x);
		CommonData.queueLogs.put(log);
		out.println(log);
	}
}