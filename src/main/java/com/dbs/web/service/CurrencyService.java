package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Currency;
import com.dbs.web.beans.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;
	public CurrencyService() {
		System.out.println("Currency Service ");
		// TODO Auto-generated constructor stub
	}
	public List<Currency> getAllCurrencies()
	{
		List<Currency> currencies = new ArrayList<Currency>();
		this.currencyRepository.findAll().forEach(currencie-> currencies.add(currencie));
		return currencies;
	}
}
