package report;

public class TotalReplySizeReport {

	private int totalReplySize;

	public TotalReplySizeReport(int totalRequestSize) {
		super();
		this.totalReplySize = totalRequestSize;
	}

	public int getTotalRequestSize() {
		return totalReplySize;
	}

	public void setTotalRequestSize(int totalReplySize) {
		this.totalReplySize = totalReplySize;
	}

	@Override
	public String toString() {
		return "totalReplySize = " + totalReplySize;
	}

}