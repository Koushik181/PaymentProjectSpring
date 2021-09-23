package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Transfertypes;
import com.dbs.web.beans.repository.TransfertypesRepository;

@Service
public class TransfertypesService {

	@Autowired
	private TransfertypesRepository transferTypesRepository;
	
	public TransfertypesService() {
		System.out.println("Transfer Types Service");
		// TODO Auto-generated constructor stub
	}

	public List<Transfertypes> getAllTransferTypes()
	{
		List<Transfertypes> transferTypes = new ArrayList<Transfertypes>();
		this.transferTypesRepository.findAll().forEach(transfertype-> transferTypes.add(transfertype));
		return transferTypes;
	}
}
