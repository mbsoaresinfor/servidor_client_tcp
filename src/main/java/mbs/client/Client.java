package mbs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;



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
        return response.toString();
    }
	
}
