package multiThreading;

public class ConsumerReport implements Runnable {

	private int count = 0;
	public static long maxSize = 0;
	public static long sumSize = 0;

	ConsumerReport() {

	}

	@Override
	public void run() {
		try {
			while (count < CommonData.amountOfLines) {
				consume(CommonData.queueLogs.take().getReplyBytes());
			}
		} catch (InterruptedException ex) {
		}
	}

	void consume(int temp) throws InterruptedException {
		if (temp > maxSize) {
			maxSize = temp;
		}
		sumSize += temp;
		++count;

	}
}
