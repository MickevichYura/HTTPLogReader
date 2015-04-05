package main;

public class Host {

	private String hostname;
	private int[] ip;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int[] getIp() {
		return ip;
	}

	public void setIp(int[] ip) {
		this.ip = ip;
	}

	public Host(String host) {
		String[] tokens = host.split("\\.");
		hostname = host;
		ip = new int[tokens.length];

		if (tokens.length == 4) {

			for (int i = 0; i < tokens.length; i++) {
				try {
					int tokenValue = Integer.parseInt(tokens[i]);

					if (tokenValue < 0 || tokenValue > 255) {
						ip = null;
						break;
					}

					ip[i] = tokenValue;

				} catch (NumberFormatException e) {
					ip = null;
					break;
				}
			}

		} else {
			ip = null;
		}
	}

	@Override
	public String toString() {
		return hostname;
	}
}