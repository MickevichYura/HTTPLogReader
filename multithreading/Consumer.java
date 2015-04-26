class Consumer implements Runnable {

	private ILogRecordParser parser;

	Consumer() {
		parser = new LogRecordParser();
	}

	private int count = 0;

	public void run() {

		try {
			while (count < CommonData.amountOfLines) {

				consume(CommonData.queueLines.take());
			}
		} catch (InterruptedException ex) {
		}

	}

	void consume(String x) throws InterruptedException {
		++count;
		CommonData.queueLogs.put(parser.parse(x));

	}
}