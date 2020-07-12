package mbs.protocol;

import java.util.ArrayList;
import java.util.List;

public class ProtocolBuilderHelper {
	 
	
		public  int getIndexCrc(int sizeData) {
			return sizeData / 2 + 1;
		}
		
		public  int getIndexEndData(int sizeMessage) {
			return sizeMessage - 2;
		}
		
				
		public  String parserData(List<String> listmessage, int initIndex, int endEndIndex) throws Exception {

			boolean paramListMessageInvalid = listmessage == null || listmessage.isEmpty();
			if(paramListMessageInvalid) {
				throw new Exception("Lista para parsear e invalida");
			}
			
			if(endEndIndex <= initIndex) {
				throw new Exception("InitIndex precisa ser menor que endEndIndex");
			}
			
			
			StringBuilder message= new StringBuilder();
			for(int i=initIndex ; i < endEndIndex ; i++) {
				message.append(listmessage.get(i));
			}
			return message.toString();
		}
		
		
		
	
		public  List<String> splitStringHex(String hexStr) throws Exception {
			String messageError = "Formato da StringHexadecimal esta invalida. ";
			List<String> ret =  new ArrayList<String>();
	    	
			boolean paramInvalid = hexStr == null || hexStr.isEmpty();
			if(paramInvalid) {
	    		throw new Exception("Formato da StringHexadecimal esta em branco ou null. ");
	    	}
			
			if((hexStr.length() % 2) != 0) {
	    		throw new Exception(messageError + hexStr);
			}
			
		    try {
			    for (int i = 0; i < hexStr.length(); i += 2) {
			        String str = hexStr.substring(i, i + 2);
			        ret.add(str);
			    }
		    }catch(Exception e)	{
		    	throw new Exception(messageError + hexStr,e);
		    }
		    return ret;
		}
		
		public  String hexToAscii(String hexStr) {
		    StringBuilder output = new StringBuilder("");
		    
		    for (int i = 0; i < hexStr.length(); i += 2) {
		        String str = hexStr.substring(i, i + 2);
		        output.append((char) Integer.parseInt(str, 16));
		    }
		    
		    return output.toString();
		}
		
		public String toHexString(int value) {
			String ret = Integer.toHexString(value);
			if(ret.length() == 1) {
				ret = "0"+ret;
			}
			return ret.toUpperCase();
			
		}
	 
	 
}
