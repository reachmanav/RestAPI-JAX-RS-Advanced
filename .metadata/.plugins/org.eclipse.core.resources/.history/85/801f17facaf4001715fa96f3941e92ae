package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.exception.DataNotFoundException;
import org.koushik.javabrains.messenger.model.Message;

public class MessageService {

	Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService()  {
		messages.put(1L, new Message(1,"Default message 1","Manav1"));
		messages.put(2L,  new Message(2,"Default message 2", "Puja2"));
	}
	
	public List<Message> getAllMessagesForYear(int year)  {
		
		List<Message> messagesForYear = new ArrayList<Message> ();
		Calendar cal = Calendar.getInstance();
		
		for (Message msg: new ArrayList<Message>( messages.values()  ))  {
			cal.setTime(msg.getCreated());
			if (cal.get(Calendar.YEAR) == year)
				messagesForYear.add(msg);
		}
		
		return messagesForYear;
		
	}
	
	public List<Message> getMessagesPaginated (int startIndex, int pageSize)  {
		List<Message> messagesPageList = new ArrayList<Message>( messages.values());
		
		if (startIndex>=0 && pageSize >=0 && !(messagesPageList.isEmpty()))
				return messagesPageList.subList(startIndex, startIndex+pageSize);
		else
			return new ArrayList<Message>();
	}
	
	public List<Message> getAllMessages()  {
		return new ArrayList<Message>( messages.values());
	}
	
	public Message getMessage(long id)  {
		
		Message message =  messages.get(id);
		
		if (message == null)  
			throw new DataNotFoundException("!!!Message with id" + id + " not found!!");
		
		return message;
	}
	
	public Message addMessage(Message message)  {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)  {
		if (message.getId() <= 0)  {
			
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public void removeMessage (long id)  {
		 messages.remove(id);		
		//return message;
	}
	
	
}
