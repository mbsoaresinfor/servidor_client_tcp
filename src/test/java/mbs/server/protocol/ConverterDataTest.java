package mbs.server.protocol;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;
import mbs.server.protocol.ConverterData;
import mbs.server.protocol.Protocol;
import mbs.server.protocol.data.DataSimple;
import mbs.server.protocol.data.InformationUser;


public class ConverterDataTest {

	private ConverterData converter = new ConverterData();
	
	@Test
	public void testToDataSimpleWithError() {
		Protocol protocol = new Protocol();
		try {
			protocol.setData("");
			converter.toDataSimple(protocol);
			Assert.fail();
		}catch(Exception e) {}
		
		try {
			protocol.setData("abc");
			converter.toDataSimple(protocol);
			Assert.fail();
		}catch(Exception e) {}
		
		try {
			protocol.setData(null);
			converter.toDataSimple(protocol);
			Assert.fail();
		}catch(Exception e) {}
		
	}
	
	@Test
	public void testToDataSimpleOk() {
		Protocol protocol = new Protocol();
		try {
			protocol.setData("48656C6C6F20576F726C64");
			DataSimple dataSimple =  converter.toDataSimple(protocol);
			Assert.assertEquals("Hello World", dataSimple.getData());
		}catch(Exception e) {
			Assert.fail();
		}
		
		try {
			protocol.setData("6d617263656c6f");
			DataSimple dataSimple =  converter.toDataSimple(protocol);
			Assert.assertEquals("marcelo", dataSimple.getData());
		}catch(Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testToDataInformationUserWithError() {
		Protocol protocol = new Protocol();
		try {
			protocol.setData("");
			converter.toInformationUser(protocol);
			Assert.fail();
		}catch(Exception e) {}
		
		try {
			protocol.setData("abc");
			converter.toInformationUser(protocol);
			Assert.fail();
		}catch(Exception e) {}
		
		try {
			protocol.setData(null);
			converter.toInformationUser(protocol);
			Assert.fail();
		}catch(Exception e) {}
		
	}
	
	@Test
	public void testToDataInformationUserOK() {
		Protocol protocol = new Protocol();
		try {
			protocol.setData("2650AB076d617263656c6f");
			InformationUser inforUser = converter.toInformationUser(protocol);
			Assert.assertEquals("marcelo", inforUser.getNome());			
			Assert.assertEquals(171, inforUser.getAltura());
			Assert.assertEquals(80, inforUser.getPeso());
			Assert.assertEquals(38, inforUser.getIdade());
			Assert.assertEquals(7, inforUser.getTamanhoNome());
			
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	
	
	
	

}
