package report;

import main.LogRecord;

public class MaxReplyBytesReport {

	private LogRecord maxReplyBytes;

	public MaxReplyBytesReport(LogRecord maxReplyBytes) {
		super();
		this.maxReplyBytes = maxReplyBytes;
	}

	public LogRecord getMaxReplyBytes() {
		return maxReplyBytes;
	}

	public void setMaxReplyBytes(LogRecord maxReplyBytes) {
		this.maxReplyBytes = maxReplyBytes;
	}

	@Override
	public String toString() {
		return "maxReplyBytes = " + maxReplyBytes.getReplyBytes();
	}
}