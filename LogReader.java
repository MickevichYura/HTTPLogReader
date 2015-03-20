import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class LogReader implements ILogFileParser {

	public List<String> getLines(String path, int startLineNumber,
			int amountOfLines) throws IOException {

		LineNumberReader reader = new LineNumberReader(new FileReader(path));

		String line;
		List<String> lines = new ArrayList<String>();
		while ((amountOfLines != 0) && ((line = reader.readLine()) != null)) {

			if (reader.getLineNumber() >= startLineNumber) {
				lines.add(line);
				--amountOfLines;
			}
		}
		reader.close();
		return lines;
	}

}
