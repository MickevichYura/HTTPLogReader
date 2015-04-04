public class ReportGenerator3 implements
		IReportGenerator<ReportParameters, Report3> {

	@Override
	public Report3 generateReport(ReportParameters p) {
		return new Report3();
	}

}
