import java.util.List;

public interface ILogParser {
	public static final String TIMESTAMP_PATTERN = "[dd/MMM/yyyy:HH:mm:ss Z]";

	public Log parseString(String line);

	public List<Log> parseString(List<String> lines);
}
