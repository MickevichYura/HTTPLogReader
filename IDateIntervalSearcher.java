import java.util.Date;
import java.util.List;

public interface IDateIntervalSearcher {
	public List<LogRecord> findByDate(Date startDate, Date endDate);
}
