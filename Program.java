import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		InputData data = new InputData(args);
		if (data.isCorrect()) {
			ILogProcessor logProcessor = new LogProcessor();
			logProcessor.process(data);
		} else {
			System.out.print(data.getErrorMessage());
		}

	}
}