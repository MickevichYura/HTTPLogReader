package report;

public interface IReportGenerator<ReportParams, Report> {
	Report generateReport(ReportParams p);
}
