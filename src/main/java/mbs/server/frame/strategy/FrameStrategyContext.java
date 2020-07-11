package mbs.server.frame.strategy;

import mbs.server.protocol.Protocol;

public class FrameStrategyContext {
	
	public FrameStrategy execute(Protocol protocol) throws Exception {

		FrameStrategy ret = null;
	
		if(Frames.MessageText.getFrame().equals(protocol.getFrame())) {
			ret= new MessageTextFrameStrategyImpl();
		}else if(Frames.InformationUser.getFrame().equals(protocol.getFrame())) {
			ret= new InformationUserFrameStrategyImpl();
		}else if(Frames.RequestDataHour.getFrame().equals(protocol.getFrame())) {
			ret= new RequestDataHourFrameStrategyImpl();
		}else {
			throw new Exception("Frame desconhecido: " + protocol.getFrame());
		}

		
		
		
	
		
		return ret;
	}

	
	
	

	
}
