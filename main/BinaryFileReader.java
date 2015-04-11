package main;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileReader implements IReader {

	@Override
	public List<String> getLines(String path, int startLineNumber,
			int amountOfLines) throws IOException {

		DataInputStream reader = new DataInputStream(new FileInputStream(path));
		String line;
		List<String> lines = new ArrayList<String>();

		int counter = 0;
		while ((amountOfLines != 0) && ((line = reader.readUTF()) != null)) {
			++counter;
			if (counter >= startLineNumber) {
				lines.add(line);
				--amountOfLines;
			}
		}
		reader.close();
		return lines;
	}

}
