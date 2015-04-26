import java.util.List;

public interface ILogRecordParser extends DateFormat {
	LogRecord parse(String line);

	List<LogRecord> parse(List<String> lines);
}
