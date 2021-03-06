package main;

import java.util.Date;

public class LogRecord {

	private Host host;
	private Date timestamp;
	private String request;
	private int replyCode;
	private int replySize;

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	public int getReplySize() {
		return replySize;
	}

	public void setReplySize(int replyBytes) {
		this.replySize = replyBytes;
	}

	@Override
	public String toString() {
		return "host=" + host + ", timestamp=" + timestamp + ", request="
				+ request + ", replyCode=" + replyCode + ", replySize="
				+ replySize;
	}

}
