package mbs.frame.strategy;

public enum Frames {

	ACK("A0"),MessageText("A1"),InformationUser("A2"),RequestDataHour("A3"),ErrorServer("50");
	
	private String frame;
	
	Frames(String frame) {
		this.frame = frame;
	}
	
	public String getFrame() {
		return this.frame;
	}
	
	
}
