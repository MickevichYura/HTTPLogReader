package multiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import main.LogRecord;

public class CommonData {
	public static final BlockingQueue<String> queueLines = new ArrayBlockingQueue<>(
			10000);

	public static final BlockingQueue<LogRecord> queueLogs = new ArrayBlockingQueue<>(
			10000);

	public static final int startLineNumber = 1;
	public static final int amountOfLines = 1891714;
}
