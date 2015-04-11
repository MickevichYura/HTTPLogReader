package main;

import java.io.IOException;
import java.util.List;

public interface IReader {

	List<String> getLines(String path, int startLineNumber, int amountOfLines)
			throws IOException;
}
