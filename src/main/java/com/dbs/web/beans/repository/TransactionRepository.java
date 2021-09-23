package com.dbs.web.beans.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Transaction;

public interface TransactionRepository  extends CrudRepository<Transaction, String>{

}
