import java.text.SimpleDateFormat;
import java.util.Locale;

public interface DateFormat {
	String TIMESTAMP_PATTERN = "[dd/MMM/yyyy:HH:mm:ss Z]";
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(TIMESTAMP_PATTERN,
			Locale.US);
}
