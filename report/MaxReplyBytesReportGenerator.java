package report;

import java.util.Collections;

import main.LogRecord;

public class MaxReplyBytesReportGenerator implements
		IReportGenerator<ReportParameters, MaxReplyBytesReport> {

	@Override
	public MaxReplyBytesReport generateReport(ReportParameters p) {
		LogRecord max = Collections.max(p.getLogs(),
				(log1, log2) -> Integer.compare(log1.getReplyBytes(),
                        log2.getReplyBytes()));
		return new MaxReplyBytesReport(max);
	}
}
