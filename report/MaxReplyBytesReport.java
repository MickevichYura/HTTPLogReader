package report;

import main.LogRecord;

public class MaxReplyBytesReport implements IReport {

	private LogRecord maxReplyBytes;

	public MaxReplyBytesReport(LogRecord maxReplyBytes) {
		super();
		this.maxReplyBytes = maxReplyBytes;
	}

	@Override
	public String toString() {
		return "maxReplyBytes = " + maxReplyBytes.getReplyBytes();
	}
}
