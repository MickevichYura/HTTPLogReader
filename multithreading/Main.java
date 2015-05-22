package multiThreading;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import database.DatabaseConnect;
import main.InputData;
import main.LogRecord;

public class Main {

	public static void main(String[] args) throws InterruptedException,
			IOException, ClassNotFoundException, SQLException {
		long before = System.currentTimeMillis();
		
		String databasePath = "D:\\Dropbox\\logs.s3db";	
		readFromDatabase(databasePath);
		
		//runThreads(args);
		

		long after = System.currentTimeMillis();
		long time = (after - before);
		System.out.println("time " + time);

	}

	public static void readFromDatabase(String path) throws ClassNotFoundException,
			SQLException {
		DatabaseConnect.connectToDatabase(path);
		DatabaseConnect.createDatabase();

		String query = "sum(replySize)";
		DatabaseConnect.ReadDatabase(query);
		query = "max(replySize)";
		DatabaseConnect.ReadDatabase(query);
		System.out.println();

		DatabaseConnect.CloseDatabase();
	}

	public static void runThreads(String[] args) throws IOException, InterruptedException {
		InputData data = new InputData(args);

		final BlockingQueue<String> queueLines = new ArrayBlockingQueue<>(10000);

		final BlockingQueue<LogRecord> queueLogs = new ArrayBlockingQueue<>(
				10000);

		Thread threadProducer = new Thread(
				new Producer(data.getInputFilePath(), 1,
						data.getAmountOfLines(), queueLines));
		threadProducer.setName("Producer");
		Thread threadConsumer1 = new Thread(new Consumer(
				data.getOutputFilePath(), data.getAmountOfLines(), queueLines,
				queueLogs));
		threadConsumer1.setName("Consumer 1");
		Thread threadConsumerReports = new Thread(new ConsumerReport(
				data.getAmountOfLines(), queueLogs, data.getStartDate(),
				data.getEndDate()));
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
	}
}
