
package testReport;



class DocumentHead {
	private String filePath;
	
	public void addCustomStylesheet(String cssFilePath) {
		String link = "<link href='file:///" + cssFilePath + "' rel='stylesheet' type='text/css' />";
		String markup = FileReaderEx.readAllText(filePath)
						.replace(MarkupFlag.get("customcss"), link + MarkupFlag.get("customcss"));
		
		FileWriterEx.write(filePath, markup);
	}
	
	public void addCustomStyles(String styles) {
		styles = "<style type='text/css'>" + styles + "</style>";
		String markup = FileReaderEx.readAllText(filePath)
						.replace(MarkupFlag.get("customcss"), styles + MarkupFlag.get("customcss"));
		
		FileWriterEx.write(filePath, markup);
	}
	
	public DocumentHead setFile(String filePath) {
		this.filePath = filePath;
		return this;
	}
	
	public DocumentHead() {}
	
	public DocumentHead(String filePath) {
		this.filePath = filePath;
	} 
}
