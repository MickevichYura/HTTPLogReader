package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LogRecordWriter implements IWriter {

	@Override
	public void write(String path, List<LogRecord> logRecords)
			throws IOException {

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				path)));

		logRecords.forEach(out::println);

		out.close();
	}
}
