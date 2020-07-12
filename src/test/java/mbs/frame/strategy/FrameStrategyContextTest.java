package mbs.frame.strategy;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import mbs.frame.strategy.FrameStrategyContext;
import mbs.frame.strategy.Frames;
import mbs.protocol.Protocol;

public class FrameStrategyContextTest {

	FrameStrategyContext stratey = new FrameStrategyContext();
	
	@Test
	public void testExecuteOk() throws Exception {
		Protocol protocol = new Protocol();
		protocol.setFrame(Frames.MessageText.getFrame());
		Assert.assertNotNull(stratey.execute(protocol));
		
		protocol = new Protocol();
		protocol.setFrame(Frames.InformationUser.getFrame());
		Assert.assertNotNull(stratey.execute(protocol));
		
		 protocol = new Protocol();
		protocol.setFrame(Frames.RequestDataHour.getFrame());
		Assert.assertNotNull(stratey.execute(protocol));
	}
	
	@Test(expected=Exception.class)
	public void testExecuteError() throws Exception {
		Protocol protocol = new Protocol();
		protocol.setFrame("ab");
		Assert.assertNotNull(stratey.execute(protocol));
	}

}
