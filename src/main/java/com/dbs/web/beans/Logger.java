package com.dbs.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Incubating;

@Entity
public class Logger implements Serializable{

	@Id
	@Column(name = "loggerid")
	private int loggerId;
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="userid")
	private Customeruser customerUser;
	@OneToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	@Column(name = "screename")
	private String screeName;
	
	@Column(name = "action")
	private String action;
	@Column(name = "ipaddress")
	private String ipAddress;
	
	public Logger() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Logger(int loggerId, Customer customer, Customeruser customerUser, Employee employee, String screeName,
			String action, String ipAddress) {
		super();
		this.loggerId = loggerId;
		this.customer = customer;
		this.customerUser = customerUser;
		this.employee = employee;
		this.screeName = screeName;
		this.action = action;
		this.ipAddress = ipAddress;
	}


	public int getLoggerId() {
		return loggerId;
	}


	public void setLoggerId(int loggerId) {
		this.loggerId = loggerId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Customeruser getCustomerUser() {
		return customerUser;
	}


	public void setCustomerUser(Customeruser customerUser) {
		this.customerUser = customerUser;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getScreeName() {
		return screeName;
	}


	public void setScreeName(String screeName) {
		this.screeName = screeName;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


	@Override
	public String toString() {
		return "Logger [loggerId=" + loggerId + ", customer=" + customer + ", customerUser=" + customerUser
				+ ", employee=" + employee + ", screeName=" + screeName + ", action=" + action + ", ipAddress="
				+ ipAddress + "]";
	}


}
