package report;

public interface IReportGenerator<ReportParams, Report> {
	public Report generateReport(ReportParams p);
}
