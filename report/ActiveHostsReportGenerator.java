package report;

import java.util.ArrayList;
import java.util.Collections;
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
			if (dict.containsKey(log.getHost().toString())) {
				dict.put(log.getHost().toString(),
						dict.get(log.getHost().toString()) + 1);
			} else {
				dict.put(log.getHost().toString(), 1);
			}
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				dict.entrySet());
		Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

		if (ActiveHostsReport.numberOfHosts > list.size())
			return new ActiveHostsReport(list);
		return new ActiveHostsReport(list.subList(0,
				ActiveHostsReport.numberOfHosts));

	}
}
