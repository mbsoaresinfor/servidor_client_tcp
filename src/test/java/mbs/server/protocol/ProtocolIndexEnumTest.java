package mbs.server.protocol;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProtocolIndexEnumTest {

	

	@Test
	public void testValuesIndex() {
		Assert.assertEquals(3, ProtocolIndexEnum.InitDataProtocol.getValue());
		Assert.assertEquals(2, ProtocolIndexEnum.FrameProtocol.getValue());
		Assert.assertEquals(1, ProtocolIndexEnum.ByteProtocol.getValue());
		
	}
		
	

}
