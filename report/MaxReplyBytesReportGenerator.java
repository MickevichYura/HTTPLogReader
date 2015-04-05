package report;

import java.util.Collections;
import java.util.Comparator;

import main.LogRecord;

public class MaxReplyBytesReportGenerator implements
		IReportGenerator<ReportParameters, MaxReplyBytesReport> {

	@Override
	public MaxReplyBytesReport generateReport(ReportParameters p) {
		LogRecord max = Collections.max(p.getLogs(),
				new Comparator<LogRecord>() {
					@Override
					public int compare(LogRecord log1, LogRecord log2) {
						return Integer.compare(log1.getReplyBytes(),
								log2.getReplyBytes());
					}
				});
		return new MaxReplyBytesReport(max);
	}
}
