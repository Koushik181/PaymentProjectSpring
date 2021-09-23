package com.dbs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Employee;
import com.dbs.web.beans.repository.EmployeeRepository;
import com.dbs.web.exception.EntityNotFoundException;


@Service
public class EmployeeService {


	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean searchEmployeeById(String empid) throws Exception
	{
		try {
			if(this.employeeRepository.findById(empid).isPresent())
				return true;
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

	public boolean addEmployee(Employee employee) throws Exception {

		try {
			if(this.searchEmployeeById(employee.getEmployeeId()))
			{
				return false;
			}
			this.employeeRepository.save(employee);
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

}
