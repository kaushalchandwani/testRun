

package testReport;

import java.util.HashMap;



public class FontAwesomeIco {
	private static HashMap<LogStatus, String> map = new HashMap<LogStatus, String>();
	
	public static void override(LogStatus status, String icon) {
		map.put(status, icon);
	}
	
	public static String get(LogStatus status) {
		if (map.containsKey(status))
	        return map.get(status);
	
		if(status.toString().toLowerCase().equals(new String("fail"))) {
			return "times";
		}
		else if (status.toString().toLowerCase().equals(new String("error"))) {
			return "exclamation-circle";
		}
		else if (status.toString().toLowerCase().equals(new String("fatal"))) {
			return "exclamation-circle";
		}
		else if (status.toString().toLowerCase().equals(new String("pass"))) {
			return "check";
		}
		else if (status.toString().toLowerCase().equals(new String("info"))) {
			return "info";
		}
		else if (status.toString().toLowerCase().equals(new String("warning"))) {
			return "warning";
		}
		else if (status.toString().toLowerCase().equals(new String("skip"))) {
			return "angle-double-right";
		}
		else {
	        return "question";
		}
	}
}
