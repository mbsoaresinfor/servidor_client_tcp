package mbs.protocol;

public enum ProtocolIndexEnum {

	ByteProtocol(1),
	FrameProtocol(2),
	InitDataProtocol(3);
	
	private int value;
	
	ProtocolIndexEnum(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
	
}
