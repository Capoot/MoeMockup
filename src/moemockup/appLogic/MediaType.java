package moemockup.appLogic;

public class MediaType {
	
	private String name;
	private String link;
	
	public MediaType(String name, String link) {
		this.name = name;
		this.link = link;
	}

	public String getName() {
		return name;
	}
	
	public String getLink() {
		return link;
	}
}