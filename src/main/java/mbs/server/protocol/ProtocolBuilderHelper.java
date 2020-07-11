package mbs.server.protocol;

import java.util.ArrayList;
import java.util.List;

class ProtocolBuilderHelper {
	 
//		public static final int INDEX_BYTE_ON_PROTOCOL = 1;
//		public static final int INDEX_FRAME_ON_PROTOCOL = 2;
//		public static final int INDEX_INIT_DATA_ON_PROTOCOL = 3;
	
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
	 
	 
}
