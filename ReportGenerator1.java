public class ReportGenerator1 implements
		IReportGenerator<ReportParameters, Report1> {

	@Override
	public Report1 generateReport(ReportParameters p) {
		return new Report1();
	}

}