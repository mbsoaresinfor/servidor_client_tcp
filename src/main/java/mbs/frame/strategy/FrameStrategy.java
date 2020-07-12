package mbs.frame.strategy;


import mbs.protocol.Protocol;

public interface FrameStrategy {

	Protocol executeStrategy(Protocol protocol) throws Exception;
	
}
