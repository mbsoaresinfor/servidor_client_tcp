package mbs.server;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;

import mbs.cdi.BeansContext;
import mbs.repository.Repository;
import mbs.repository.RepositoryProxy;
import mbs.service.DataHourService;
import mbs.service.DataHourServiceImpl;
import mbs.service.MessageService;
import mbs.service.MessageServiceImpl;
import mbs.service.UserService;
import mbs.service.UserServiceImpl;

/**
 * Classe para iniciar o servidor tcp
 * 
 * @author marcelo.soares
 *
 */
public class MainServer {
	
	public static void main(String[] args) throws IOException {

		addBeansContext();
		
		DOMConfigurator.configure("log4j.xml");
		
		Server server = new Server();
		server.start();

	}
	
	private static void addBeansContext() {
		// TODO melhorias. Inserir um framework de CDI.
		RepositoryProxy repositoryProxy =  new RepositoryProxy();
		MessageService messageService = new MessageServiceImpl(repositoryProxy);
		UserService userService = new UserServiceImpl(repositoryProxy);
		DataHourService dataHourService = new DataHourServiceImpl();
		
		BeansContext.getInstance().addService(Repository.class, repositoryProxy);
		BeansContext.getInstance().addService(MessageService.class, messageService);
		BeansContext.getInstance().addService(UserService.class, userService);
		BeansContext.getInstance().addService(DataHourService.class, dataHourService);
		
	}
	
	
	
}
