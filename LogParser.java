import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LogParser implements ILogParser {

	public Log parseString(String line) {
		char quotationMark = '\"';
		int indexOfQuotationMark = line.indexOf(quotationMark);
		int lastIndexOfQuotationMark = line.lastIndexOf(quotationMark);
		int lastIndexOfSpace = line.lastIndexOf(" ");

		Log log = new Log();

		log.setHost(new Host(line.substring(0, line.indexOf(" - - "))));

		log.setRequest(line.substring(indexOfQuotationMark,
				lastIndexOfQuotationMark) + quotationMark);

		log.setReplyCode(Integer.parseInt(line.substring(
				lastIndexOfQuotationMark + 2, lastIndexOfSpace)));

		try {
			log.setReplyBytes(Integer.parseInt(line
					.substring(lastIndexOfSpace + 1)));
		} catch (NumberFormatException e) {
			log.setReplyBytes(0);
		}

		log.setTimestamp(new SimpleDateFormat(TIMESTAMP_PATTERN, Locale.US)
				.parse(line,
						new ParsePosition(line.indexOf(TIMESTAMP_PATTERN
								.charAt(0)))));

		return log;
	}

	public List<Log> parseString(List<String> lines) {
		List<Log> logs = new ArrayList<Log>();

		for (String line : lines) {
			logs.add(parseString(line));
		}

		return logs;
	}

}