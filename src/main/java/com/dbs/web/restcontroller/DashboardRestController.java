package com.dbs.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Bank;
import com.dbs.web.beans.Customer;
import com.dbs.web.exception.EntityNotFoundException;
import com.dbs.web.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class DashboardRestController {

	@Autowired
	private CustomerService customerService;
	
	public DashboardRestController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/customerData")
	public ResponseEntity<Object> getCustomerDataFromCID(@RequestBody Customer sender) {
		Customer customer = null;
		try {
			System.out.println("sender data "+sender);
			
			 customer = this.customerService.findCustomerById(sender.getCustomerId());
			 
			 System.out.println("customer data"+customer);
			
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				customer);
	}
}
