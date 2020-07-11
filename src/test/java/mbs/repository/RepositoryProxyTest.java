package mbs.repository;

import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;
import mbs.entity.MessageEntity;

public class RepositoryProxyTest {

	private RepositoryProxy proxy =  new RepositoryProxy();
	
	@Test
	public void testSave() {
		 MessageEntity message = new MessageEntity();		 
		 message.setDateReceiver(new Date());
		 message.setMessage("novo teste");
		 proxy.save(message);
		 MessageEntity fromDataBase = (MessageEntity) proxy.get(1l,MessageEntity.class);
		 Assert.assertNotNull(fromDataBase);
	}
}
