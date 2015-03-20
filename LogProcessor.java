import java.io.IOException;

public class LogProcessor implements ILogProcessor {

	@Override
	public void process(InputData data) throws IOException {
		ILogWriter logRecordPrint = new LogWriter();
		ILogFileParser logFileParser = new LogReader();
		ILogParser logParser = new LogParser();

		logRecordPrint.write(data.getOutputFilePath(), logParser
				.parseString(logFileParser.getLines(data.getInputFilePath(),
						data.getStartLineNumber(), data.getAmountOfLines())));

	}
}
