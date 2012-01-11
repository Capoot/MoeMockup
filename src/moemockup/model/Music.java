package moemockup.model;

public class Music {

	private long id;
	
	private String filename;
	private byte[] rawData;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getRawData() {
		return rawData;
	}

	public void setRawData(byte[] rawData) {
		this.rawData = rawData;
	}
	
	public int getSize() {
		return rawData.length;
	}
}
