public class Report2 {

	private int totalRequestSize;

	public Report2(int totalRequestSize) {
		super();
		this.totalRequestSize = totalRequestSize;
	}

	public int getTotalRequestSize() {
		return totalRequestSize;
	}

	public void setTotalRequestSize(int totalRequestSize) {
		this.totalRequestSize = totalRequestSize;
	}

	@Override
	public String toString() {
		return "totalRequestSize = " + totalRequestSize;
	}

}
