package report;

public interface IReportGenerator<ReportParams, Report extends IReport> {
	Report generateReport(ReportParams p);
}
