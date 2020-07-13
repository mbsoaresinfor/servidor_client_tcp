package mbs.protocol.validation;

import mbs.crc.Crc8;
import mbs.protocol.Protocol;

public class ValidationCRCProtocol implements ValidationProtocol {

	@Override
	public void validate(Protocol protocol) throws Exception {

		Crc8.calc(protocol);

	}

}
