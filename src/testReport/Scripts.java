

package testReport;



class Scripts {
	private String filePath;
	
	public void insertJS(String script) {
		script = "<script type='text/javascript'>" + script + "</script>";
		String markup = FileReaderEx.readAllText(filePath)
						.replace(MarkupFlag.get("customscript"), script + MarkupFlag.get("customscript"));
		
		FileWriterEx.write(filePath, markup);
	}
	
	public Scripts setFile(String filePath) {
		this.filePath = filePath;
		return this;
	}
	
	public Scripts() {}
	
	public Scripts(String filePath) {
		this.filePath = filePath;
	}
}
