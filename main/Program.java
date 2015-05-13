package main;

import java.io.IOException;

class Program {

	public static void main(String[] args) throws IOException {

		InputData data = new InputData(args);
		
		if (data.isCorrect()) {
			long before = System.currentTimeMillis();
			ILogRecordParser logRecordParser = new LogRecordParser();
			IWriter writer = new LogRecordWriter();
			//IReader reader = new BinaryFileReader();
			IReader reader = new LogFileReader();
			
			ILogRecordProcessor logRecordProcessor = new LogRecordProcessor(
					logRecordParser, writer, reader);
			logRecordProcessor.process(data);
			
			long after = System.currentTimeMillis();
			long time = (after - before);
			System.out.println("time " + time);
		} else {
			System.out.print(data.getErrorMessage());
		}

	}
}
