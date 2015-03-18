import java.io.IOException;
import java.util.List;

public interface ILogWriter {
	void write(String path, List<Log> logs) throws IOException;
}
