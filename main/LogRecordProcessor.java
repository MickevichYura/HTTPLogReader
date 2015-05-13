package main;

import java.util.List;
import java.io.IOException;

import report.DateIntervalSearcher;
import report.IDateIntervalSearcher;
import report.IReport;
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
	private IReader reader;

	public LogRecordProcessor(ILogRecordParser logRecordParser, IWriter writer, IReader reader) {
		this.logRecordParser = logRecordParser;
		this.writer = writer;
		this.reader = reader;
	}

	@Override
	public void process(InputData data) throws IOException {

		List<LogRecord> logRecords = logRecordParser.parse(reader.getLines(
				data.getInputFilePath(), data.getStartLineNumber(),
				data.getAmountOfLines()));

		writer.write(data.getOutputFilePath(), logRecords);

		IDateIntervalSearcher s = new DateIntervalSearcher(logRecords);

		logRecords = s.findByDate(data.getStartDate(), data.getEndDate());
		ReportParameters params = new ReportParameters(logRecords);
		IReportGenerator<ReportParameters, ? extends IReport> report;
		switch (data.getReportNumber()) {
		case 1: {
			report = new ActiveHostsReportGenerator();			
			break;
		}

		case 2: {
			report = new TotalReplySizeReportGenerator();
			break;
		}

		case 3: {
			report = new MaxReplyBytesReportGenerator();
			break;
		}

		default:{
			report = null;
			break;
		}
			
		}
		System.out.println(report.generateReport(params));
	}
}
