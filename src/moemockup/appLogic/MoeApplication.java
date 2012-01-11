package moemockup.appLogic;

import java.util.LinkedList;
import java.util.List;

public class MoeApplication {

	private String contextPath;
	private LinkedList<MediaType> availableMedia = new LinkedList<MediaType>();
	
	public MoeApplication(String contextPath) {
		this.contextPath = contextPath;
		availableMedia.add(new MediaType("Music (MP3)", "music"));
	}
	
	public String getContext() {
		return contextPath;
	}
	
	public List<MediaType> getAvailableMedia() {
		return availableMedia;
	}
}
