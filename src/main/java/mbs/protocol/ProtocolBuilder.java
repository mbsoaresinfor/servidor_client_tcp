package mbs.protocol;

import java.util.List;

import mbs.frame.strategy.Frames;

public class ProtocolBuilder {

	private ProtocolBuilder() {}
	

	public static class Builder{

		private String bytes;
		private String frame;
		private String data;
		private String crc;
		
		public Builder(){
		}
		
		public Builder addByte(String bytes){
			this.bytes= bytes;
			return this;
		}
		
		public Builder addCrc(String crc){
			this.crc = crc;
			return this;
		}
		
		public Builder addData(String data){
			this.data= data;
			return this;
		}
		
		public Builder addFrame(String frame){
			this.frame = frame;
			return this;
		}
		
		public Protocol builderProtocol() throws Exception{
			Protocol protocol = new Protocol();
			protocol.setBytes(bytes);
			protocol.setCrc(crc);
			protocol.setData(data);
			protocol.setFrame(frame);
			return protocol;
			
		}
		
		public Protocol builderProtocolACK() throws Exception{
			Protocol protocol = new Protocol();
			protocol.setBytes("05");
			protocol.setCrc("28");
			protocol.setData("");
			protocol.setFrame(Frames.ACK.getFrame());
			return protocol;
			
		}
		
	}
	
	public static class BuilderFromStringHex{
	
		private ProtocolBuilderHelper helper = new ProtocolBuilderHelper();
		public Protocol builderProtocol(String stringHex) throws Exception{

			List<String> listStringHex = helper.splitStringHex(stringHex);		
			Protocol protocol = new Protocol();
			protocol.setBytes(listStringHex.get(ProtocolIndexEnum.ByteProtocol.getValue()));
			protocol.setFrame(listStringHex.get(ProtocolIndexEnum.FrameProtocol.getValue()));
			int end = Integer.parseInt(protocol.getBytes(), 16) ;
			protocol.setData(helper.parserData(listStringHex,ProtocolIndexEnum.InitDataProtocol.getValue(),helper.getIndexEndData(end)));			
			int indexCrc =helper.getIndexCrc(protocol.getData().length());
			protocol.setCrc(listStringHex.get(indexCrc));			
			
			return protocol;
			
		}
		
	}
		
	

	
}
