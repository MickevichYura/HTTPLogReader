import java.util.List;
import java.io.IOException;

public class LogRecordProcessor implements ILogRecordProcessor {

	private ILogRecordParser logRecordParser;
	private IWriter writer;

	public LogRecordProcessor(ILogRecordParser logRecordParser, IWriter writer) {
		this.logRecordParser = logRecordParser;
		this.writer = writer;
	}

	@Override
	public void process(InputData data) throws IOException {

		IReader reader = new LogFileReader();

		List<LogRecord> logRecords = logRecordParser.parse(reader.getLines(
				data.getInputFilePath(), data.getStartLineNumber(),
				data.getAmountOfLines()));

		writer.write(data.getOutputFilePath(), logRecords);

		IDateIntervalSearcher s = new DateIntervalSearcher(logRecords);

		logRecords = s.findByDate(data.getStartDate(), data.getEndDate());
		ReportParameters params = new ReportParameters(logRecords);

		switch (data.getReportNumber()) {
		case 1: {
			IReportGenerator<ReportParameters, Report1> r1 = new ReportGenerator1();
			System.out.println(r1.generateReport(params));
			break;
		}

		case 2: {
			IReportGenerator<ReportParameters, Report2> r2 = new ReportGenerator2();
			System.out.println(r2.generateReport(params));
			break;
		}

		case 3: {
			IReportGenerator<ReportParameters, Report3> r3 = new ReportGenerator3();
			System.out.println(r3.generateReport(params));
			break;
		}

		default:
			break;
		}
	}
}