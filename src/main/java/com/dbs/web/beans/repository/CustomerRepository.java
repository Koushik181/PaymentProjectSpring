package com.dbs.web.beans.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, String>{

	List<Customer> findByuserName(String userName);
}
