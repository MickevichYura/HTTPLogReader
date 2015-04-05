package main;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface DateFormat {
	String DATE_FORMAT_PATTERN = "[dd/MMM/yyyy:HH:mm:ss Z]";
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN,
			Locale.US);
}
