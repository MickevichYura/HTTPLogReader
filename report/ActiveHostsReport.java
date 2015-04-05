package report;

import java.util.List;

public class ActiveHostsReport {

	public static final int numberOfHosts = 5;
	private List<Object> hosts;

	public ActiveHostsReport(List<Object> hosts) {
		super();
		this.hosts = hosts;
	}

	public List<Object> getHosts() {
		return hosts;
	}

	public void setHosts(List<Object> hosts) {
		this.hosts = hosts;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object host : hosts) {
			sb.append(host.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
