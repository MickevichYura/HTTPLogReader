package report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.LogRecord;

public class ActiveHostsReportGenerator implements
		IReportGenerator<ReportParameters, ActiveHostsReport> {

	@Override
	public ActiveHostsReport generateReport(ReportParameters p) {
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
		if (ActiveHostsReport.numberOfHosts > list.size())
			return new ActiveHostsReport(list);
		return new ActiveHostsReport(list.subList(0, ActiveHostsReport.numberOfHosts));

	}

}