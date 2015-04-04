import java.util.Date;
import java.util.List;

public class DateIntervalSearcher implements IDateIntervalSearcher,
		ILogSearcher {

	private List<LogRecord> logs;

	public DateIntervalSearcher(List<LogRecord> logs) {
		super();
		this.logs = logs;
	}

	@Override
	public List<LogRecord> findByDate(Date startDate, Date endDate) {

		int startIndex = binarySearch(startDate, 0, logs.size());
		int endIndex = binarySearch(endDate, startIndex, logs.size());

		return logs.subList(startIndex, endIndex);
	}

	@Override
	public int binarySearch(Date key, float left, float right) {

		float mid = (left + right) / 2;

		if (left == mid || mid == right)
			return (int) mid;

		if (logs.get((int) mid).getTimestamp().after(key))
			return binarySearch(key, left, mid);
		else
			return binarySearch(key, mid, right);
	}
}