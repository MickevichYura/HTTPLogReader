import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		ILogProcessor logProcessor = new LogProcessor();
		logProcessor.process(args);

	}
}