package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;


	public CustomerService() {
		System.out.println("Customer service");
	}

	public Customer findCustomerById(String id) throws Exception
	{
		Customer customer = null;
		try {

			Optional<Customer> opt = this.customerRepository.findById(id);
			if(opt.isPresent())
				customer = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return customer;

	}
	
	public List<Customer> findCustomerByUsername(String username) throws Exception
	{
		List<Customer> cstList =  new ArrayList<>();
		try {

			cstList = this.customerRepository.findByuserName(username);
			
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return cstList;

	}

	public boolean addCustomer(Customer customer) throws Exception {

		try {
			if(this.customerRepository.findById(customer.getCustomerId()).isPresent())
			{
				return false;
			}
			this.customerRepository.save(customer);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}
	public boolean updateCustomer(Customer customer) throws Exception {

		try {
			if(this.customerRepository.findById(customer.getCustomerId()).isPresent())
			{
				this.customerRepository.save(customer);
				return true;
			}	
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return false;
	}

}
