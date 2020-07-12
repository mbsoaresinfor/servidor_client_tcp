package mbs.server;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

import mbs.protocol.Protocol;

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
	        out.write(messageToSendClient.toString());
	        out.flush();

	        	
	     } catch (Throwable e) {
	        	LOG.error("Error on " + toString() ,e);
	     }finally {
	        	closeCloseable(new Closeable[] {socket,in,out});	        	
		}	      
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



