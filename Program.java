import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		int numberOfStartLine = Integer.valueOf(args[0]);
		int amountOfLines = Integer.valueOf(args[1]);

		ILogWriter logRecordPrint = new LogWriter();
		ILogFileParser logFileParser = new LogReader();
		ILogParser logParser = new LogParser();

		logRecordPrint.write(args[3], logParser.parseString(logFileParser
				.getLines(args[2], numberOfStartLine, amountOfLines)));

	}
}