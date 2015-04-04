import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

public class LogRecordParser implements ILogRecordParser {

	public LogRecord parse(String line) {
		char quotationMark = '\"';
		int indexOfQuotationMark = line.indexOf(quotationMark);
		int lastIndexOfQuotationMark = line.lastIndexOf(quotationMark);
		int lastIndexOfSpace = line.lastIndexOf(" ");

		LogRecord logRecord = new LogRecord();

		logRecord.setHost(new Host(line.substring(0, line.indexOf(" - - "))));

		logRecord.setRequest(line.substring(indexOfQuotationMark,
				lastIndexOfQuotationMark) + quotationMark);

		logRecord.setReplyCode(Integer.parseInt(line.substring(
				lastIndexOfQuotationMark + 2, lastIndexOfSpace)));

		try {
			logRecord.setReplyBytes(Integer.parseInt(line
					.substring(lastIndexOfSpace + 1)));
		} catch (NumberFormatException e) {
			logRecord.setReplyBytes(0);
		}

		logRecord.setTimestamp(DATE_FORMAT.parse(line,
				new ParsePosition(line.indexOf(TIMESTAMP_PATTERN.charAt(0)))));

		return logRecord;
	}

	public List<LogRecord> parse(List<String> lines) {
		List<LogRecord> logRecords = new ArrayList<LogRecord>();

		for (String line : lines) {
			logRecords.add(parse(line));
		}

		return logRecords;
	}

}