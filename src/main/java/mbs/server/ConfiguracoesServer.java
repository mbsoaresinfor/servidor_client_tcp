package mbs.server;


public class ConfiguracoesServer {
	
	private int port = 2222;
	private int tamanhoPoolClient = 10;

	
	public int getTamanhoPoolClient() {
		return tamanhoPoolClient;
	}

	public void setTamanhoPoolClient(int tamanhoPoolClient) {
		this.tamanhoPoolClient = tamanhoPoolClient;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
