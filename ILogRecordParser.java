import java.util.List;

public interface ILogRecordParser {
	String TIMESTAMP_PATTERN = "[dd/MMM/yyyy:HH:mm:ss Z]";

	LogRecord parse(String line);

	List<LogRecord> parse(List<String> lines);
}
