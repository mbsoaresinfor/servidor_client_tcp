package mbs.server;


import org.apache.log4j.Logger;

import mbs.cdi.BeansContext;
import mbs.entity.MessageEntity;
import mbs.frame.strategy.FrameStrategy;
import mbs.frame.strategy.FrameStrategyContext;
import mbs.protocol.Protocol;
import mbs.protocol.ProtocolBuilder;
import mbs.protocol.validation.ValidationCRCProtocol;
import mbs.service.MessageService;

public class ProcessMessageFromClientImpl implements ProcessMessageFromClient {
	
	private static Logger LOG = Logger.getLogger("file-server");
	private FrameStrategyContext frameStrategyContext = new FrameStrategyContext();
	private MessageService messageService = (MessageService) BeansContext.getInstance().getService(MessageService.class);
	private ValidationCRCProtocol validationCRCProtocol = (ValidationCRCProtocol)BeansContext.getInstance().getService(ValidationCRCProtocol.class);
	
	public Protocol process(String message) throws Exception {
		
		LOG.info(message);
		
		Protocol protocol = new	ProtocolBuilder.BuilderFromStringHex().builderProtocol(message);
		
		validationCRCProtocol.validate(protocol);

		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setMessage(protocol.toString());
		messageService.save(messageEntity);
		
		FrameStrategy frameStratey =  frameStrategyContext.execute(protocol);
		
		Protocol protocolResponse = frameStratey.executeStrategy(protocol);
		
		return protocolResponse;

	}
	
	

}
