package com.dbs.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Bank;
import com.dbs.web.beans.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	public BankService() {
		System.out.println("Bank Service");
		// TODO Auto-generated constructor stub
	}
	
	public Bank findBankByBIC(String bic) throws Exception
	{
		Bank bank = null;
		try {

			Optional<Bank> opt = this.bankRepository.findById(bic);
			if(opt.isPresent())
				bank = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("BIC cannot be null, Please provide valid BIC");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return bank;

	}


}
