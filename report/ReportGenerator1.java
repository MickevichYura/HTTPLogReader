package report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.LogRecord;

public class ReportGenerator1 implements
		IReportGenerator<ReportParameters, Report1> {

	@Override
	public Report1 generateReport(ReportParameters p) {
		Map<String, Integer> dict = new HashMap<String, Integer>();
		for (LogRecord log : p.getLogs()) {
			if (dict.containsKey(log.getHost().toString()))
				dict.put(log.getHost().toString(),
						dict.get(log.getHost().toString()) + 1);
			else
				dict.put(log.getHost().toString(), 1);
		}

		List list = new ArrayList(dict.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> b,
					Map.Entry<String, Integer> a) {
				return a.getValue().compareTo(b.getValue());
			}
		});
		if (Report1.numberOfHosts > list.size())
			return new Report1(list);
		return new Report1(list.subList(0, Report1.numberOfHosts));

	}

}