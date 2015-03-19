import java.io.IOException;

public class LogProcessor implements ILogProcessor {
    public void process(String[] args) throws IOException {
        ILogWriter logRecordPrint = new LogWriter();
        ILogFileParser logFileParser = new LogReader();
        ILogParser logParser = new LogParser();

        int numberOfStartLine = Integer.valueOf(args[0]);
        int amountOfLines = Integer.valueOf(args[1]);

        logRecordPrint.write(args[3], logParser.parseString(logFileParser
                .getLines(args[2], numberOfStartLine, amountOfLines)));
    }
}