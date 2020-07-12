package mbs.protocol;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import mbs.protocol.ProtocolBuilderHelper;

public class ProtocolBuilderHelperTest {

	private ProtocolBuilderHelper helper = new ProtocolBuilderHelper();;

	
	
	
	@Test
	public void testSplitStringHexWithError() {
		try {
			helper.splitStringHex("");
			Assert.fail();
		}catch(Exception e) {			
		}
		
		try {
			helper.splitStringHex("abc");
			Assert.fail();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testSplitStringHexOK() {
		try {
			helper.splitStringHex("abAc");
		}catch(Exception e) {
			Assert.fail();			
		}
		
	}
	
	@Test
	public void testGetIndexEndData() {		
		Assert.assertEquals(0,helper.getIndexEndData(2));
		Assert.assertEquals(2,helper.getIndexEndData(4));
		Assert.assertEquals(7,helper.getIndexEndData(9));
	}
	

	@Test
	public void testGetIndexCrc() {	
		Assert.assertEquals(2,helper.getIndexCrc(2));
		Assert.assertEquals(13,helper.getIndexCrc(24));
	}
	
	
	@Test
	public void testparserDataWithError() throws Exception {
		try {
		 helper.parserData(new ArrayList<String>(), 0, 0);
		 Assert.fail();
		}catch(Exception e) {}
		
		try {
			 helper.parserData(null, 0, 0);
			 Assert.fail();
		}catch(Exception e) {}
		
		try {
			 List<String> list = new ArrayList<String>();
			 list.add("ab");
			 
			 helper.parserData(list, 0, 0);
			 Assert.fail();
		}catch(Exception e) {}
		
		try {
			 List<String> list = new ArrayList<String>();
			 list.add("ab");
			 
			 helper.parserData(list, 1, 0);
			 Assert.fail();
		}catch(Exception e) {}	

		
	}
	
	@Test
	public void testparserDataOK() throws Exception {
		try {
			 List<String> list = new ArrayList<String>();
			 list.add("ab");
			 
			 helper.parserData(list, 0, 1);
		}catch(Exception e) {
			Assert.fail();
		}	
	}
	

}
