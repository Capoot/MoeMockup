package moemockup.persistence;

import java.util.LinkedList;
import java.util.List;

import moemockup.model.Music;

public class MoeStorage {

	private LinkedList<Music> music = new LinkedList<Music>();
	private long idAutoValue = 0;
	
	public void save(Music m) {
		if(music.contains(m)) {
			return;
		}
		m.setId(++idAutoValue);
		music.add(m);
	}
	
	public void remove(long id) {
		Music item = null;
		for(Music m : music) {
			if(m.getId() == id) {
				item = m;
				break;
			}
		}
		if(item == null) {
			String message = String.format("Could not delete music (invalid id %d)", id);
			throw new RuntimeException(message);
		}
		music.remove(item);
	}
	
	public List<Music> getAllMusic() {
		return music;
	}
	
	public Music loadMusic(long id) {
		for(Music m : music) {
			if(m.getId() == id) {
				return m;
			}
		}
		String message = String.format("Could not load music (invalid id %d)", id);
		throw new RuntimeException(message);
	}
}
