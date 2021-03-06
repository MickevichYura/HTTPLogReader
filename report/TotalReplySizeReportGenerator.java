package report;

import main.LogRecord;

public class TotalReplySizeReportGenerator implements
		IReportGenerator<ReportParameters, TotalReplySizeReport> {

	@Override
	public TotalReplySizeReport generateReport(ReportParameters p) {

		long totalRequestSize = 0;
		for (LogRecord log : p.getLogs()) {
			totalRequestSize += log.getReplySize();
		}
		return new TotalReplySizeReport(totalRequestSize);
	}
}
