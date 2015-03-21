import java.io.IOException;
import java.util.List;

public interface IWriter {
	void write(String path, List<LogRecord> logRecords) throws IOException;
}
