package reimbursement.resources;

//this class allows easy insertion of custom runtime elements into html documents previously created by the class
public class HTMLFactory {
	private static final String[] skeleton =
		{
				"<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>",
				
				"</title>"
				+ "<meta charset=\"UTF-8\">"
				+ "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">"
				+ "<style>",
				
				"</style>"
				+ "<script>",
				
				"</script>"
				+ "</head>"
				+ "<body>",
				
				"</body>"
				+ "</html>"
		};
	public String getCss() {
		return css;
	}

	public String getJs() {
		return js;
	}

	public String getBody() {
		return body;
	}

	public String getTitle() {
		return title;
	}

	private String css;
	private String js;
	private String body;
	private String title;
	
	private String plaintext;
	
	public HTMLFactory()
	{
		super();
	}

	public void setCss(String css) {
		this.css = css;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public void compile()
	{
		this.plaintext=skeleton[0]+this.title+skeleton[1]+this.css+skeleton[2]+this.js+skeleton[3]+this.body+skeleton[4];
	}
	
	public void addError(String error)
	{
		String csscopy=this.css;
		String bodycopy=this.body;

		this.css+=
				".error{"
						+ "color: black; "
						+ "font-size: 16px; "
						+ "text-align: center;"
						+ "display: block; "
						+ "}\r\n";
		this.body+=
				"<br><div class=error>" + error +"</div>"
						+ "<br>";
		compile();
		this.css=csscopy;
		this.body=bodycopy;
	}
	
	public String toString()
	{
		return this.plaintext;
	}
	

}
