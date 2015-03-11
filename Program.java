import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class LineReader {

    public static void main(String[] args) throws IOException,
            FileNotFoundException {

        int startLine = Integer.valueOf(args[0]);
        int amountOfLines = Integer.valueOf(args[1]);
        LineNumberReader reader = new LineNumberReader(new FileReader(args[2]));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                args[3])));
        String line;
        while ((line = reader.readLine()) != null && amountOfLines != 0) {

            if (reader.getLineNumber() >= startLine) {
                Log log = LogParser.parseString(line);
                out.println(log);
                --amountOfLines;
            }
        }

        out.close();
        reader.close();
    }
}
