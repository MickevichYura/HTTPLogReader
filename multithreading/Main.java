package multiThreading;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		long before = System.currentTimeMillis();

		Thread threadProducer = new Thread(new Producer(args[0]));
		threadProducer.setName("Producer");
		Thread threadConsumer1 = new Thread(new Consumer(args[1]));
		threadConsumer1.setName("Consumer 1");
		Thread threadConsumerReports = new Thread(new ConsumerReport());
		threadConsumerReports.setName("Consumer Reports");

		threadProducer.start();
		threadConsumer1.start();
		threadConsumerReports.start();

		threadProducer.join();
		threadConsumer1.join();
		threadConsumerReports.join();

		System.out.println(ConsumerReport.totalReplySize);
		System.out.println(ConsumerReport.maxReplyBytes);
		System.out.println(ConsumerReport.activeHosts);
		
		long after = System.currentTimeMillis();
		long time = (after - before);
		System.out.println("time " + time);

	}

}
