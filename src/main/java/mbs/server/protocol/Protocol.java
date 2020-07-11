package mbs.server.protocol;

import java.io.Serializable;

public class Protocol implements Serializable{

	
	private static final long serialVersionUID = 8803371093993337321L;
	private final String INIT = "0A";
	private final String END = "0D";

	private String bytes;
	private String frame;
	private String data;
	private String crc;
	
	
	public String getBytes() {
		return bytes;
	}
	public void setBytes(String bytes) {
		this.bytes = bytes;
	}
	public String getFrame() {
		return frame;
	}
	public void setFrame(String frame) {
		this.frame = frame;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCrc() {
		return crc;
	}
	public void setCrc(String crc) {
		this.crc = crc;
	}
	public String getINIT() {
		return INIT;
	}
	public String getEND() {
		return END;
	}

	public String toString() {
		StringBuilder ret = new StringBuilder();
		return ret.append(INIT).append(bytes).append(frame).append(data).append(crc).append(END).toString();
	}
	

	
	
}
