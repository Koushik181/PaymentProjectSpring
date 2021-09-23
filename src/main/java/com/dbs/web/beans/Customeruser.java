package com.dbs.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customeruser implements Serializable{

	@Id
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "username")
	private String userName;
	@Column(name = "userpassword")
	private String userPassword;
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	public Customeruser(int userId, String userName, String userPassword, Customer customer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.customer = customer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	public Customeruser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", customer=" + customer + "]";
	}

}
