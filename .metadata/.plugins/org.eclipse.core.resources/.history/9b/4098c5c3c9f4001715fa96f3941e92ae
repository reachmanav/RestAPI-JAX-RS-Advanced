package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.model.ErrorMessage;
import org.koushik.javabrains.messenger.model.Message;

public class CommentsService {

	Map<Long, Message> messages = DatabaseClass.getMessages();
	Map <Long,Comment> commentsService = DatabaseClass.getComments();
	
	public List<Comment> getAllComments()  {
		return new ArrayList<Comment> (commentsService.values());
	}
	
	public Comment getComment(long messageId, long commentId)  {
		Message message = messages.get(messageId);
		
		ErrorMessage ex = new ErrorMessage("Not found",404,"http://www.javabrains.io");
		Response response = Response.status(Status.BAD_REQUEST)
									.entity(ex)
									.build();
		
		if (message == null)
			throw new WebApplicationException(response);
		
		return messages.get(messageId).getComments().get(commentId);
	}
	
	public Comment addComment(long messageId, Comment newComment)  {
		//return messages.get(messageId).getComments().put(2L, newComment);
		Map<Long,Comment> messagecomments = messages.get(messageId).getComments();
		newComment.setId(messagecomments.size()+1); 
		
		System.out.println("newComment.getAuthor:" + newComment.getAuthor());
		System.out.println("newComment.getComment:" + newComment.getComment());
		System.out.println("newComment.getId:" + newComment.getId());
		System.out.println("newComment.getCreated:" + newComment.getCreated());
		
		messagecomments.put(newComment.getId(), newComment);
		
		System.out.println("messagecomments.getAuthor:" + messagecomments.get(newComment.getId()).getAuthor());
		System.out.println("messagecomments.getComment:" + messagecomments.get(newComment.getId()).getComment());
		System.out.println("messagecomments.getId:" + messagecomments.get(newComment.getId()).getId());
		System.out.println("messagecomments.getCreated:" + messagecomments.get(newComment.getId()).getCreated());
		return newComment;
	}
	
	public Comment updateComment(long messageId, Comment updatedComment)  {
		Map<Long,Comment> messagecomments = messages.get(messageId).getComments();
		
		if (updatedComment.getId() <=0)
			return null;
		
		messagecomments.put(updatedComment.getId(), updatedComment);
		return updatedComment;
	}
	
	
	public void removeComment(long messageId, long commentId)  {
		Map<Long,Comment> messagecomments = messages.get(messageId).getComments();
		messagecomments.remove(commentId);
	}
	
		
}
