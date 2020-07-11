package mbs.client;

public class MainClient {

	public static void main(String[] args) {

		Client client = new Client();
		ClientView view = new ClientView();
		view.start(client);

	}

}
