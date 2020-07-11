package mbs.server.frame.strategy;

import org.apache.log4j.Logger;

import mbs.server.protocol.ConverterData;
import mbs.server.protocol.Protocol;
import mbs.server.protocol.ProtocolBuilder;
import mbs.server.protocol.data.DataSimple;

public class MessageTextFrameStrategyImpl implements FrameStrategy {

	private static Logger LOG = Logger.getLogger(MessageTextFrameStrategyImpl.class);
	
	@Override
	public Protocol executeStrategy(Protocol protocol) throws Exception {

		
		DataSimple dataSimple = new ConverterData().toDataSimple(protocol);
		LOG.info("------------------------------------------------------------------------");
		LOG.info("\t\tDADOS RECEBIDOS: " + dataSimple.toString());
		LOG.info("------------------------------------------------------------------------");
		
		return new ProtocolBuilder.Builder().builderProtocolACK();
	}

}
