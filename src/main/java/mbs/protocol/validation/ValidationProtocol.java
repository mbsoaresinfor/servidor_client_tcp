package mbs.protocol.validation;

import mbs.protocol.Protocol;

public interface ValidationProtocol {

	void validate(Protocol protocol) throws Exception;
	
}
