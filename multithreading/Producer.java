import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Producer implements Runnable {

	private LineNumberReader reader;
	private int count = CommonData.amountOfLines;

	Producer(String path) {
		try {
			reader = new LineNumberReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		try {
			String line;
			while (count >= 0 && (line = produce()) != null) {
				CommonData.queueLines.put(line);
			}
			reader.close();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	String produce() {
		try {
			--count;
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}