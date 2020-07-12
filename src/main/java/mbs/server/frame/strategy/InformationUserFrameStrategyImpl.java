package mbs.server.frame.strategy;

import org.apache.log4j.Logger;

import mbs.cdi.BeansContext;
import mbs.entity.MessageEntity;
import mbs.entity.UserEntity;
import mbs.frame.strategy.FrameStrategy;
import mbs.protocol.ConverterData;
import mbs.protocol.Protocol;
import mbs.protocol.ProtocolBuilder;
import mbs.protocol.data.InformationUser;
import mbs.service.UserService;

public class InformationUserFrameStrategyImpl implements FrameStrategy {

	private static Logger LOG = Logger.getLogger(InformationUserFrameStrategyImpl.class);
	private UserService userService = (UserService)BeansContext.getInstance().getService(UserService.class);
	
	
	@Override
	public Protocol executeStrategy(Protocol protocol) throws Exception {
		
		InformationUser informationUser = new ConverterData().toInformationUser(protocol);
		LOG.info("------------------------------------------------------------------------");
		LOG.info("\t\tDADOS RECEBIDOS: " + informationUser.toString());
		LOG.info("------------------------------------------------------------------------");
		
		UserEntity userEntity = new UserEntity();
		userEntity.setAltura(informationUser.getAltura());
		userEntity.setIdade(informationUser.getIdade());
		userEntity.setNome(informationUser.getNome());
		userEntity.setPeso(informationUser.getPeso());
		
		userService.save(userEntity);
		
		return new ProtocolBuilder.Builder().builderProtocolACK();
	}

}
