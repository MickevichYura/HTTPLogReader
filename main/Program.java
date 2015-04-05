package main;

import java.io.IOException;

class Program {

	public static void main(String[] args) throws IOException {

		InputData data = new InputData(args);
		if (data.isCorrect()) {
			ILogRecordParser logRecordParser = new LogRecordParser();
			IWriter writer = new LogRecordWriter();
			ILogRecordProcessor logRecordProcessor = new LogRecordProcessor(
					logRecordParser, writer);
			logRecordProcessor.process(data);
		} else {
			System.out.print(data.getErrorMessage());
		}

	}
}