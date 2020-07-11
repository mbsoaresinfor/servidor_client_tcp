package mbs.service;

import java.util.Date;

import mbs.entity.MessageEntity;
import mbs.repository.Repository;

public class MessageServiceImpl implements MessageService {

	private Repository repository ;
	
	public MessageServiceImpl(Repository messageRepository) {
		this.repository = messageRepository;
	}
	
	public void save(MessageEntity messageEntity) {
		
		messageEntity.setDateReceiver(new Date());
		repository.save(messageEntity);

	}

}
