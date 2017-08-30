
package testReport;



class Header {
	private String filePath;
	
	public void setHeadline(String newSummary) {
		String markup = FileReaderEx.readAllText(filePath);
		String pattern = MarkupFlag.get("reportsummary") + ".*" + MarkupFlag.get("reportsummary");
		newSummary = pattern.replace(".*", newSummary); 
		
		String oldSummary = RegexMatcher.getNthMatch(markup, pattern, 0);
		markup = markup.replace(oldSummary, newSummary);
		
		FileWriterEx.write(filePath, markup);
	}
	
	public Header setFile(String filePath) {
		this.filePath = filePath;
		return this;
	}
	
	public Header() {}
	
	public Header(String filePath) {
		this.filePath = filePath;
	} 
}
