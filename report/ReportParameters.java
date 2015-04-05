package report;

import java.util.List;

import main.LogRecord;

public class ReportParameters {

	private List<LogRecord> logs;

	public ReportParameters(List<LogRecord> logs) {
		super();
		this.logs = logs;
	}

	public List<LogRecord> getLogs() {
		return logs;
	}
}
