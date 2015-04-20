package report;

public class TotalReplySizeReport {

	private int totalReplySize;

	public TotalReplySizeReport(int totalRequestSize) {
		super();
		this.totalReplySize = totalRequestSize;
	}

	@Override
	public String toString() {
		return "totalReplySize = " + totalReplySize;
	}

}
