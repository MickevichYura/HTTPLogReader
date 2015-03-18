import java.util.List;

public interface ILogParser {
	String TIMESTAMP_PATTERN = "[dd/MMM/yyyy:HH:mm:ss Z]";

	Log parseString(String line);

	List<Log> parseString(List<String> lines);
}
