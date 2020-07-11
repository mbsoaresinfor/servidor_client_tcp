package mbs.server;


import org.apache.log4j.Logger;

import mbs.cdi.BeansContext;
import mbs.entity.MessageEntity;
import mbs.server.frame.strategy.FrameStrategy;
import mbs.server.frame.strategy.FrameStrategyContext;
import mbs.server.protocol.Protocol;
import mbs.server.protocol.ProtocolBuilder;
import mbs.service.MessageService;

public class ProcessMessageFromClientImpl implements ProcessMessageFromClient {
	
	private static Logger LOG = Logger.getLogger("file-server");
	private FrameStrategyContext frameStrategyContext = new FrameStrategyContext();
	private MessageService messageService = (MessageService) BeansContext.getInstance().getService(MessageService.class);
	
	public Protocol process(String message) throws Exception {
		
		LOG.info(message);
		
		Protocol protocol = new	ProtocolBuilder.BuilderFromStringHex().builderProtocol(message);

		// validacao geral ack
		// validacao especificas
		// TODO escrerver em arquivo os dados.
		
		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setMessage(protocol.toString());
		messageService.save(messageEntity);
		
		FrameStrategy frameStratey =  frameStrategyContext.execute(protocol);
		
		Protocol protocolResponse = frameStratey.executeStrategy(protocol);
		
		return protocolResponse;

	}
	
	

}
