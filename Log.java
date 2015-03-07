import java.util.Date;

public class Log {

	private Object host;

	public Object getHost() {
		return host;
	}

	public void setHost(Object host) {
		this.host = host;
	}

	private Date timestamp;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	private String request;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	private int replyCode;

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	private int replyBytes;

	public int getReplyBytes() {
		return replyBytes;
	}

	public void setReplyBytes(int replyBytes) {
		this.replyBytes = replyBytes;
	}

	@Override
	public String toString() {
		return "host=" + host + ", timestamp=" + timestamp + ", request="
				+ request + ", replyCode=" + replyCode + ", replyBytes="
				+ replyBytes;
	}
}