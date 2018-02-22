package org.koushik.javabrains.messenger.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.messenger.model.Link;
import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.resources.beans.MessageFilterbean;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

// Accept Header value - maps to produces
// content-type value - maps to consumes
//@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})

public class MessageResource {

	MessageService messageService = new MessageService();
	
	
	/* public List<Message> getMessages(@QueryParam("year") int year, 
	 @QueryParam("startIndex") int startIndex, 
	 @QueryParam("pageSize") int pageSize)  { */
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterbean filterBeanObj) 
	{
		
		if(filterBeanObj.getYear()>0)  {
			System.out.println("Inside getAllMessagesForYear "+filterBeanObj.getYear());
			return messageService.getAllMessagesForYear(filterBeanObj.getYear());
		}
		
		if (filterBeanObj.getStartIndex()>=0 && filterBeanObj.getPageSize()>0)  
			return messageService.getMessagesPaginated(filterBeanObj.getStartIndex(), filterBeanObj.getPageSize());
		
		return messageService.getAllMessages();
	}
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messId, @Context UriInfo uriInfoObj)  {
		
		
		Message message = messageService.getMessage(messId);
		String uri = getURIString(messId, uriInfoObj);
		String uriProfile = getURIString(message, uriInfoObj);
		String uriComments = getURIcomments(message, uriInfoObj);
	
		message.addLink(uri, "self");
		message.addLink(uriProfile, "profile");
		message.addLink(uriComments, "commentary");
		
		
		return message;
	}

	private String getURIcomments(Message message, UriInfo uriInfoObj) {
		String uriProfile = uriInfoObj.getBaseUriBuilder()
				  .path(MessageResource.class)
				  .path(MessageResource.class,"hadOverToSubResource")
				  .resolveTemplate("messageId", message.getId())
				  .path(CommentResource.class)
				  .build()
				  .toString();

			return uriProfile;
	}

	private String getURIString(Message message, UriInfo uriInfoObj) {
		String uriProfile = uriInfoObj.getBaseUriBuilder()
									  .path(ProfileResource.class)
									  .path(message.getAuthor())
									  .build()
									  .toString();
				
		return uriProfile;
	}

	private String getURIString(long messId, UriInfo uriInfoObj) {
		
		String uri = uriInfoObj.getBaseUriBuilder()
							   .path(MessageResource.class)
							   .path(Long.toString(messId))
							   .build()
							   .toString();
		return uri;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public Response addMessage(Message newMessage, @Context UriInfo uriInfoObj)   {
		Message createdMsg = messageService.addMessage(newMessage);
		String newId = String.valueOf(createdMsg.getId());
		
		return Response.created(uriInfoObj.getAbsolutePathBuilder().path(newId).build())
					   .entity(createdMsg)
					   .build();
		/* throws URISyntaxException
		return Response.created(new URI("/messenger/webapi/messages/"+newMessage.getId()))
				.entity(createdMsg)
		        .build();
		*/
		/* return Response.status(Status.CREATED)
				        .header("location", "/messenger/webapi/messages")
						.entity(createdMsg)
				        .build();
		*/
	}
	
	
	@Path("/{messageId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long msgId, Message updatedMessage)  {
		updatedMessage.setId(msgId);
		return messageService.updateMessage(updatedMessage);
	}
	
	@Path("/{messageId}")
	@DELETE
	public void removeMessage(@PathParam("messageId") long msgId)  {
		messageService.removeMessage(msgId);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource hadOverToSubResource()  {
		return new CommentResource();
	}
 
}
