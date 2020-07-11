package mbs.server.protocol;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ProtocolTest {

	@Test
	public void testToString() {
		Protocol protocol = new Protocol();
		protocol.setBytes("b");
		protocol.setCrc("c");
		protocol.setData("d");
		protocol.setFrame("f");
		
		String ex = "0Abfdc0D";
		Assert.assertEquals(ex, protocol.toString());
		

	}
}

	