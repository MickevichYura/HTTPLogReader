import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Log {

	private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	private Date timestamp;

	public Date getDate() {
		return timestamp;
	}

	public void setDate(Date timestamp) {
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

	public Log(String line) {
		line = line.replaceAll("\r\n", " ");
		char quotationMark = '\"';
		int indexOfQuotationMark = line.indexOf(quotationMark);
		int lastIndexOfQuotationMark = line.lastIndexOf(quotationMark);
		int lastIndexOfSpace = line.lastIndexOf(" ");

		this.host = line.substring(0, line.indexOf(" - - "));
		this.request = line.substring(indexOfQuotationMark,
				lastIndexOfQuotationMark) + quotationMark;
		this.replyCode = Integer.parseInt(line.substring(
				lastIndexOfQuotationMark + 2, lastIndexOfSpace));

		try {
			this.replyBytes = Integer
					.parseInt(line.substring(lastIndexOfSpace + 1));
		} catch (NumberFormatException e) {
			this.replyBytes = 0;
		}

		String timestampPattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
		this.timestamp = new SimpleDateFormat(timestampPattern, Locale.US)
				.parse(line, new ParsePosition(line.indexOf("[")));
	}

	@Override
	public String toString() {
		return "host=" + host + ", timestamp=" + timestamp + ", request="
				+ request + ", replyCode=" + replyCode + ", replyBytes="
				+ replyBytes;
	}
}