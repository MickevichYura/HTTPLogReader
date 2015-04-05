package main;

import java.io.IOException;
import java.util.List;

public interface IReader {

	List<String> getLines(String path, int numberOfStartLine, int amountOfLines)
			throws IOException;
}
