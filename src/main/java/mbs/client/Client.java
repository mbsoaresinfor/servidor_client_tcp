package mbs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import mbs.frame.strategy.Frames;
import mbs.protocol.ProtocolBuilderHelper;
import mbs.protocol.ProtocolIndexEnum;



public class Client {

	private static Logger LOG = Logger.getLogger(Client.class);
	private static Logger LOG_FILE = Logger.getLogger("file-client");
	
	
	public String connect(String address, String portNUmber, String message) throws Exception {

 
        String hostname = address;
        int port = Integer.parseInt(portNUmber);
        StringBuilder response = new StringBuilder();
        
        try (Socket socket = new Socket(hostname, port)) {
        	//socket.setSoTimeout(5000);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(message);
 
            InputStream input = socket.getInputStream();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            String line;
 
            while ((line = reader.readLine()) != null) {
            	response.append(line);
            }
        } catch (UnknownHostException ex) {
 
            LOG.error("Server not found: " + ex.getMessage(),ex);
            throw ex;
 
        } catch (IOException ex) { 
        		LOG.error("I/O error: " + ex.getMessage(),ex);
                throw ex;
        }
        
        LOG_FILE.info(response.toString());
        return processResponse(response.toString());
    }
	
	private String processResponse(String response) throws Exception {
		StringBuffer ret = new StringBuffer();
		List<String> listRet = null;
		try {
			 listRet =  new ProtocolBuilderHelper().splitStringHex(response);			
		}catch(Exception e) {
			LOG.error("error ao processar response",e);
			throw new Exception("Error ao processar reposta do servidor");
		}
		
		boolean isFrameACK = listRet.get(ProtocolIndexEnum.FrameProtocol.getValue()).equals(Frames.ACK.getFrame());
		boolean isFrameRequesDataHour = listRet.get(ProtocolIndexEnum.FrameProtocol.getValue()).equals(Frames.RequestDataHour.getFrame());
		boolean isFrameErrorServer = listRet.get(ProtocolIndexEnum.FrameProtocol.getValue()).equals(Frames.ErrorServer.getFrame());
		if(isFrameACK) {
			ret.append("ACK");
		}else if(isFrameErrorServer) {
			throw new Exception("Error no processamento da requisição no servidor.\nVerifique o error na console do servidor");
		}else if(isFrameRequesDataHour) {
			ret.append(Integer.parseInt((listRet.get(ProtocolIndexEnum.InitDataProtocol.getValue())),16));
			ret.append("/");
			ret.append(Integer.parseInt(listRet.get(ProtocolIndexEnum.InitDataProtocol.getValue() +1),16));
			ret.append("/");
			ret.append(Integer.parseInt(listRet.get(ProtocolIndexEnum.InitDataProtocol.getValue() + 2),16));
			ret.append(" ");
			ret.append(Integer.parseInt(listRet.get(ProtocolIndexEnum.InitDataProtocol.getValue() + 3),16));
			ret.append(":");
			ret.append(Integer.parseInt(listRet.get(ProtocolIndexEnum.InitDataProtocol.getValue() + 4),16));
			ret.append(":");
			ret.append(Integer.parseInt(listRet.get(ProtocolIndexEnum.InitDataProtocol.getValue() + 5),16));
		}

		
		return ret.toString();
		
		
	}
	
}
