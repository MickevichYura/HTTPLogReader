package main;

import java.util.List;
import java.io.IOException;

import report.DateIntervalSearcher;
import report.IDateIntervalSearcher;
import report.IReportGenerator;
import report.ActiveHostsReport;
import report.TotalReplySizeReport;
import report.MaxReplyBytesReport;
import report.ActiveHostsReportGenerator;
import report.TotalReplySizeReportGenerator;
import report.MaxReplyBytesReportGenerator;
import report.ReportParameters;

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
			IReportGenerator<ReportParameters, ActiveHostsReport> r1 = new ActiveHostsReportGenerator();
			System.out.println(r1.generateReport(params));
			break;
		}

		case 2: {
			IReportGenerator<ReportParameters, TotalReplySizeReport> r2 = new TotalReplySizeReportGenerator();
			System.out.println(r2.generateReport(params));
			break;
		}

		case 3: {
			IReportGenerator<ReportParameters, MaxReplyBytesReport> r3 = new MaxReplyBytesReportGenerator();
			System.out.println(r3.generateReport(params));
			break;
		}

		default:
			break;
		}
	}
}