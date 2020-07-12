package mbs.server;

import mbs.protocol.Protocol;

public interface ProcessMessageFromClient {

	Protocol process(String message) throws Exception;
	

	
}
