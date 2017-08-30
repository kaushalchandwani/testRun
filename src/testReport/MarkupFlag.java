
package testReport;

public class MarkupFlag {
	public static String get(String flag) {
		return "<!--%%" + flag.toUpperCase() + "%%-->";
	}
	
	public static String img(String imgPath) {
		return "<img class='report-img' data-featherlight='file:///" + imgPath + "' src='file:///" + imgPath + "' />";
	}
	
	public static String imgSingle(String imgPath) {
		return "<img class='report-img-large' data-featherlight='file:///" + imgPath + "' src='file:///" + imgPath + "' />";
	}
}
