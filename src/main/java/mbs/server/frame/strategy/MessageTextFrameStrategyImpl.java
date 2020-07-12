package mbs.server.frame.strategy;

import org.apache.log4j.Logger;

import mbs.frame.strategy.FrameStrategy;
import mbs.protocol.ConverterData;
import mbs.protocol.Protocol;
import mbs.protocol.ProtocolBuilder;
import mbs.protocol.data.DataSimple;

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
