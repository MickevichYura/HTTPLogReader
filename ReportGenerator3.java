import java.util.Collections;
import java.util.Comparator;

public class ReportGenerator3 implements
		IReportGenerator<ReportParameters, Report3> {

	@Override
	public Report3 generateReport(ReportParameters p) {
		LogRecord max = Collections.max(p.getLogs(),
				new Comparator<LogRecord>() {
					@Override
					public int compare(LogRecord log1, LogRecord log2) {
						return Integer.compare(log1.getReplyBytes(),
								log2.getReplyBytes());
					}
				});
		return new Report3(max);
	}
}