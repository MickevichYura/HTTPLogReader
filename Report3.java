public class Report3 {

	private LogRecord maxReplyBytes;

	public Report3(LogRecord maxReplyBytes) {
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
