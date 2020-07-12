package mbs.frame.strategy;

import mbs.protocol.Protocol;
import mbs.server.frame.strategy.InformationUserFrameStrategyImpl;
import mbs.server.frame.strategy.MessageTextFrameStrategyImpl;
import mbs.server.frame.strategy.RequestDataHourFrameStrategyImpl;

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
