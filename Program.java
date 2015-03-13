import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException,
            FileNotFoundException {

        int numberOfStartLine = Integer.valueOf(args[0]);
        int amountOfLines = Integer.valueOf(args[1]);

        LogWriter.write(args[3], LogParser.parseString(LogReader.getLines(
                args[2], numberOfStartLine, amountOfLines)));

    }
}