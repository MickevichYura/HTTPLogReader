import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public abstract class LogWriter {

	public static void write(String path, List<Log> logs) throws IOException {

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				path)));

		for (Log log : logs) {
			out.println(log);
		}

		out.close();
	}
}
