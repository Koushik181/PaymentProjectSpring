package com.dbs.web.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customeruser;
import com.dbs.web.beans.repository.CustomeruserRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService{

	public AccountUserDetailsService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CustomeruserRepository repo;
	
	//@Autowired

	//private PasswordEncoder encode;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Username "+username);
		Optional<Customeruser> optional = this.repo.findByCustomerCustomerId(username);
		return optional.map(account ->{
			User user = new User(account.getCustomer().getCustomerId(),account.getUserPassword(),
					new ArrayList<>());
			return user;
		}).orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
	}
}
