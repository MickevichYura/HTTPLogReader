import java.io.IOException;

public interface ILogRecordProcessor {
	void process(InputData data) throws IOException;
}
