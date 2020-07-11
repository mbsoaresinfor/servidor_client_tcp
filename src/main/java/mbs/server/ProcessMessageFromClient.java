package mbs.server;

import mbs.server.protocol.Protocol;

public interface ProcessMessageFromClient {

	Protocol process(String message) throws Exception;
	

	
}
