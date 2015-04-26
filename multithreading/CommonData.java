import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CommonData {
	public static final BlockingQueue<String> queueLines = new ArrayBlockingQueue<>(
			1000);
	
	public static final BlockingQueue<LogRecord> queueLogs = new ArrayBlockingQueue<>(1000);
	
	public static final int amountOfLines = 1891714;
}
