public class ReportGenerator2 implements
		IReportGenerator<ReportParameters, Report2> {

	@Override
	public Report2 generateReport(ReportParameters p) {

		int totalRequestSize = 0;
		for (LogRecord log : p.getLogs()) {
			totalRequestSize += log.getReplyBytes();
		}
		return new Report2(totalRequestSize);
	}
}