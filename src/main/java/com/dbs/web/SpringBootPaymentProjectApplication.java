package com.dbs.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dbs.web.beans.Customeruser;
import com.dbs.web.beans.repository.CustomeruserRepository;
import com.dbs.web.service.CustomerService;


@SpringBootApplication
public class SpringBootPaymentProjectApplication {
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(SpringBootPaymentProjectApplication.class, args);
		
		System.out.println("Koushik");
	}
	
	@Autowired
	private CustomeruserRepository repo;
	
	@Autowired
	private CustomerService service;
	
	private BCryptPasswordEncoder encoder;
	/*@PostConstruct
	@Bean
	public void initialize() throws Exception {
		System.out.println("initialize");
		//mayanna pw : mayanna
		Customeruser user = new Customeruser(3,"Krishna Mohan",new BCryptPasswordEncoder().encode("krishna"),this.service.findCustomerById("83020817828620"));
		
		repo.save(user);
		
		System.out.println(repo.count());
		
		for(Customeruser acc:repo.findAll())
				System.out.println(acc);
		
	}
	Above code has to be executed to get encrypted password to the database
	*/

}
