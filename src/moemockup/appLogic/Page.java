package moemockup.appLogic;

public enum Page {

	INDEX("index"),
	MUSIC_FORM("music_form"),
	MUSIC("music");
	
	private String id;
	
	private Page(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
