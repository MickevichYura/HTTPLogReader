import java.io.IOException;
import java.util.List;

public interface ILogWriter {
	public void write(String path, List<Log> logs) throws IOException;
}
