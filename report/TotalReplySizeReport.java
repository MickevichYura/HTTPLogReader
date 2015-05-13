package report;

public class TotalReplySizeReport implements IReport {

	private long totalReplySize;

	public TotalReplySizeReport(long totalReplySize) {
		super();
		this.totalReplySize = totalReplySize;
	}

	@Override
	public String toString() {
		return "totalReplySize = " + totalReplySize;
	}

}
