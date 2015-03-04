import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		int startLine = Integer.valueOf(args[0]);
		int amountOfLines = Integer.valueOf(args[1]);
		LineNumberReader reader = new LineNumberReader(new FileReader(args[2]));

		List<Log> logs = new ArrayList<Log>();

		PrintWriter out = new PrintWriter(args[3]);
		String line;
		while ((line = reader.readLine()) != null && amountOfLines != 0) {

			if (reader.getLineNumber() >= startLine) {
				logs.add(new Log(line));
				--amountOfLines;
			}
		}

		for (Log log : logs) {
			out.println(log);
		}

		out.close();
		reader.close();
	}
}