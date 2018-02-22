package org.manav.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.manav.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {


		Client client = ClientBuilder.newClient();
	
		/*
		Response response =  client
							.target("http://localhost:8080/advanced-jaxrs-03/webapi/messages/1")
							.request(MediaType.APPLICATION_JSON)
							.get();
							
							Message message = response.readEntity(Message.class);
							
							System.out.println(message.getMessage());
	    */
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-03/webapi");
		WebTarget messageTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		
		Message message1  =  singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		
		Message message2  =  singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		
		/* Post method review
		
		Message newMessage = new Message(33L, "Post message from RestApiClient", "dhaval");
		
		Response postResponse = messageTarget.request(MediaType.APPLICATION_JSON)
					 .post(Entity.json(newMessage));
					 
		//System.out.println(message1.getMessage());
		//System.out.println(message2.getMessage());
		
		System.out.println(postResponse.readEntity(Message.class).getMessage());
		
		*/
		
		/* Put method */
		
		Message newPutMessage = new Message(3, "PUT message from RestApiClient", "dhaval");
		
			Response putResponse = singleMessageTarget
			.resolveTemplate("messageId", "3")
			.request(MediaType.APPLICATION_JSON)
			.put(Entity.json(newPutMessage));
		
			System.out.println(putResponse.getStatus());
			System.out.println(putResponse.readEntity(Message.class).getMessage());
		

	}

}
