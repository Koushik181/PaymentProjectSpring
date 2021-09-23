package com.dbs.web.beans.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Customeruser;

public interface CustomeruserRepository  extends CrudRepository<Customeruser, Integer>{

	Optional<Customeruser> findByCustomerCustomerId(String customerId);
	
}
