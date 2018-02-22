package org.manav.javabrains.rest.client;



import java.util.Iterator;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.manav.javabrains.messenger.model.Message;

public class GenericsInvocation {

	public static void main (String args[])  {
		
		
		Client client = ClientBuilder.newClient();
		
		
		GenericType<List<Message>> genericType = new GenericType<List<Message>> () {};
		
		List<Message> messageList = client.target("http://localhost:8080/advanced-jaxrs-03/webapi")
		 	  .path("messages")
		 	  .request(MediaType.APPLICATION_JSON)
		 	  .get(genericType);
		 	  		
		Iterator<Message> it = messageList.iterator();
		
		while (it.hasNext())  			
			System.out.println(it.next().getMessage());
		
		
	}
}
