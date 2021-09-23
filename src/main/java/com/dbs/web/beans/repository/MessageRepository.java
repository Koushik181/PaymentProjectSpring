package com.dbs.web.beans.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Message;

public interface MessageRepository  extends CrudRepository<Message, String>{

}
