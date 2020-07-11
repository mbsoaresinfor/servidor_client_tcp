package mbs.client;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * Classe para iniciar o client tcp
 * 
 * @author marcelo.soares
 *
 */
public class MainClient {

	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		Client client = new Client();
		ClientView view = new ClientView();
		view.start(client);
	}

}
