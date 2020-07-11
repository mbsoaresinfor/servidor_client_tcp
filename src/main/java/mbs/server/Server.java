package mbs.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;



public class Server {

	private static Logger LOG = Logger.getLogger(Server.class);

	private ConfiguracoesServer configuracoesServer;	
	private ServerSocket server;
	private ExecutorService executorService ;
	private Integer contClientServer = 0;

	public Server(ConfiguracoesServer config) {
		this.configuracoesServer = config;
		executorService = Executors.newFixedThreadPool(configuracoesServer.getTamanhoPoolClient());
	}
	public Server() {
		this(new ConfiguracoesServer());
	}
	
	
	public void start() throws IOException {
		server = new ServerSocket(configuracoesServer.getPort());
		LOG.info("#####################################################");
		LOG.info("\t\tServidor iniciado na porta " + configuracoesServer.getPort());
		LOG.info("#####################################################");
		
		while(true) {
			Socket socket = server.accept();
			LOG.info("Requisicao recebida do endereco ip: " + socket.getInetAddress().getHostAddress());
			ClientServer client = new ClientServer(socket,++contClientServer);
			executorService.submit(client);			
		}
	}
	
	
}
