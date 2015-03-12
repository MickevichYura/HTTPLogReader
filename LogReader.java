import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class LogReader {

	public static List<Log> getLogsFromFile(String path, int numberOfStartLine,
			int amountOfLines) throws IOException {

		LineNumberReader reader = new LineNumberReader(new FileReader(path));

		String line;
		List<Log> logs = new ArrayList<Log>();
		while ((amountOfLines != 0) && ((line = reader.readLine()) != null)) {

			if (reader.getLineNumber() >= numberOfStartLine) {
				logs.add(LogParser.parseString(line));
				--amountOfLines;
			}
		}
		reader.close();
		return logs;
	}

}
