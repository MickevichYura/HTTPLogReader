import java.util.List;
import java.io.IOException;

public class LogRecordProcessor implements ILogRecordProcessor {

	private ILogRecordParser logRecordParser;
	private IWriter writer;

	public LogRecordProcessor(ILogRecordParser logRecordParser, IWriter writer) {
		this.logRecordParser = logRecordParser;
		this.writer = writer;
	}

	@Override
	public void process(InputData data) throws IOException {

		IReader reader = new LogFileReader();

		List<LogRecord> logRecords = logRecordParser.parse(reader.getLines(
				data.getInputFilePath(), data.getStartLineNumber(),
				data.getAmountOfLines()));

		writer.write(data.getOutputFilePath(), logRecords);

	}
}