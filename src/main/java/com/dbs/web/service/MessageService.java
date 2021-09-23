package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Message;
import com.dbs.web.beans.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public MessageService() {
		System.out.println("Message Service");
		// TODO Auto-generated constructor stub
	}

	public List<Message> getAllMessages()
	{
		List<Message> messages = new ArrayList<Message>();
		this.messageRepository.findAll().forEach(message-> messages.add(message));
		return messages;
	}
}
