package mbs.server;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.log4j.Logger;
import mbs.frame.strategy.Frames;
import mbs.protocol.Protocol;
import mbs.protocol.ProtocolBuilder;

public class ClientServer implements Runnable{

	private static Logger LOG = Logger.getLogger(ClientServer.class);
	private Socket socket;
	private	ProcessMessageFromClient processMessageFromClient;
	private Integer idClientServer;

	public ClientServer(Socket socket, Integer idClientServer, ProcessMessageFromClient processMessageFromClient) {
		this.socket = socket;
		this.idClientServer = idClientServer;
		this.processMessageFromClient = processMessageFromClient;
	}
	
	public ClientServer(Socket socket, Integer idClientServer) {
		this(socket,idClientServer,new ProcessMessageFromClientImpl());
	}
	
	public void run() {

		 PrintWriter out = null;
		 BufferedReader in = null;
		 
        try {            
        	out = new PrintWriter(socket.getOutputStream(), true);        	        	
        	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	
        	String message =  in.readLine();
        	message = trimMessage(message);
        	LOG.info(toString() + ", processando mensagem " + message);
	        Protocol messageToSendClient =  processMessageFromClient.process(message);
	        write(out,messageToSendClient.toString());
	        	
	     } catch (Throwable e) {
	        	LOG.error("Error on " + toString() ,e);
		        write(out,builderProtocolErrorServer().toString());
	     }finally {
	        	closeCloseable(new Closeable[] {socket,in,out});	        	
		}	      
	 }	
	
	private  Protocol builderProtocolErrorServer() {
		Protocol protocol = null;
		try {
			protocol = new ProtocolBuilder.Builder().
					addFrame(Frames.ErrorServer.getFrame()).
					addByte("05").
					addData("").
					addCrc("").
					builderProtocol();
		}catch(Exception e) {
			LOG.error(e);
		}
		return protocol;
	}
	
	private void write( PrintWriter out, String messageToSendClient) {
		LOG.info("Enviando mensagem para o cliente: " + messageToSendClient); 
		out.write(messageToSendClient.toString());
         out.flush();
	}
	
	private String trimMessage(String message) {
		String ret = message;
		if(message != null) {
			ret = message.trim();
		}
		return ret;
	}
	
	private void closeCloseable(Closeable... closeable) {
		for(Closeable c: closeable) {
			try {
				c.close();				
			}catch(Exception e) {
				LOG.error(e);
			}
		}
	}
	
	public String toString() {
		return ClientServer.class.getSimpleName()  + "-" +idClientServer;
	}
	
}		



