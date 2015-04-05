package main;

import java.io.IOException;
import java.util.List;

interface IWriter {
	void write(String path, List<LogRecord> logRecords) throws IOException;
}
