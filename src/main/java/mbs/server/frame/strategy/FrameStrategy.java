package mbs.server.frame.strategy;


import mbs.server.protocol.Protocol;

public interface FrameStrategy {

	Protocol executeStrategy(Protocol protocol) throws Exception;
	
}
