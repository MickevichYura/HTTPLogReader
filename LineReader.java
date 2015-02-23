import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineReader {

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		int startLine = Integer.valueOf(args[0]);
		int amountOfLines = Integer.valueOf(args[1]);
		LineNumberReader reader = new LineNumberReader(new FileReader(args[2]));

		String line;
		while ((line = reader.readLine()) != null
				&& amountOfLines != 0) {

			if (reader.getLineNumber() >= startLine){
				System.out.println(line);
				--amountOfLines;
			}
		}
		reader.close();
	}
}
