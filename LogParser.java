import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.StringTokenizer;

public class LogParser {

	public static Log parseString(String line) {
		char quotationMark = '\"';
		int indexOfQuotationMark = line.indexOf(quotationMark);
		int lastIndexOfQuotationMark = line.lastIndexOf(quotationMark);
		int lastIndexOfSpace = line.lastIndexOf(" ");

		Log log = new Log();

		log.setHost(LogParser.parseIpAddress(line.substring(0,
				line.indexOf(" - - "))));
		if (log.getHost() == null) {
			log.setHost(line.substring(0, line.indexOf(" - - ")));
		}

		log.setRequest(line.substring(indexOfQuotationMark,
				lastIndexOfQuotationMark) + quotationMark);
		log.setReplyCode(Integer.parseInt(line.substring(
				lastIndexOfQuotationMark + 2, lastIndexOfSpace)));

		try {
			log.setReplyBytes(Integer.parseInt(line
					.substring(lastIndexOfSpace + 1)));
		} catch (NumberFormatException e) {
			log.setReplyBytes(0);
		}

		String timestampPattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
		log.setTimestamp(new SimpleDateFormat(timestampPattern, Locale.US)
				.parse(line, new ParsePosition(line.indexOf("["))));

		return log;
	}

	private static InetAddress parseIpAddress(String host) {
		StringTokenizer tokenizer = new StringTokenizer(host, ".");
		byte[] hostAddress = new byte[tokenizer.countTokens()];

		if (tokenizer.countTokens() != 4) {
			return null;
		}

		int i = 0;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			try {
				int tokenValue = Integer.parseInt(token, 10);

				if (tokenValue < 0 || tokenValue > 255) {
					return null;
				}

				hostAddress[i++] = (byte) tokenValue;
			} catch (NumberFormatException e) {
				return null;
			}
		}

		try {
			return InetAddress.getByAddress(hostAddress);
		} catch (UnknownHostException e) {
			return null;
		}

	}

}