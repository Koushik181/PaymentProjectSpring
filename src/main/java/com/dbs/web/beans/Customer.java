package com.dbs.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Customer implements Serializable{
	
	@Id
	@Column(name = "customerid")
	private String customerId;
	@Column(name = "username")
	private String userName;
	@Column(name = "userpassword")
	private String userPassword;
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



	@Column(name = "accountholdername")
	private String accountHolderName;
	@Column(name = "overdraftflag")
	private int overDraftFlag;
	@Column(name = "clearbalance")
	private double clearBalance;
	@Column(name = "senderbic")
	private String senderBIC;
	@Column(name = "customeraddress")
	private String customerAddress;
	@Column(name = "customercity")
	private String customerCity;
	@Column(name = "customertype")
	private String customerType;
	
	

	

	public Customer(String customerId, String userName, String userPassword, String accountHolderName,
			int overDraftFlag, double clearBalance, String senderBIC, String customerAddress, String customerCity,
			String customerType) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.accountHolderName = accountHolderName;
		this.overDraftFlag = overDraftFlag;
		this.clearBalance = clearBalance;
		this.senderBIC = senderBIC;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerType = customerType;
	}
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", accountHolderName=" + accountHolderName + ", overDraftFlag=" + overDraftFlag + ", clearBalance="
				+ clearBalance + ", senderBIC=" + senderBIC + ", customerAddress=" + customerAddress + ", customerCity="
				+ customerCity + ", customerType=" + customerType + "]";
	}

	public String getSenderBIC() {
		return senderBIC;
	}

	public void setSenderBIC(String senderBIC) {
		this.senderBIC = senderBIC;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getOverDraftFlag() {
		return overDraftFlag;
	}

	public void setOverDraftFlag(int overDraftFlag) {
		this.overDraftFlag = overDraftFlag;
	}

	public double getClearBalance() {
		return clearBalance;
	}

	public void setClearBalance(double clearBalance) {
		this.clearBalance = clearBalance;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	
	
	public Customer() {
		System.out.println("customer");
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
