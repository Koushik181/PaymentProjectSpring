package com.dbs.web.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Transaction implements Serializable{

	@Id
	@Column(name = "transactionid")
	private String transactionId;
	@OneToOne
	@JoinColumn(name="customerid")

	private Customer customer;
	@OneToOne
	@JoinColumn(name="currencycode")

	private Currency currency;
	@OneToOne
	@JoinColumn(name="senderBIC")

	private Bank senderBank;
	@OneToOne
	@JoinColumn(name="receiverBIC")

	private Bank receiverBank;
	
	@Column(name = "receiveraccountholdername")
	private String receiverAccountHolderName;
	@Column(name = "receiveraccountholdernumber")
	private String receiverAccountHolderNumber;
	
	@OneToOne
	@JoinColumn(name="transfertypecode")
	private Transfertypes transferTypes;
	@OneToOne
	@JoinColumn(name="messagecode")
	private Message message;
	
	@Column(name = "currencyamount")
	private double currencyAmount;
	@Column(name = "transferfees")
	private double transferFees;
	@Column(name = "inramount")
	private double inrAmount;
	@Column(name = "date")
	private Date date;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionId, Customer customer, Currency currency, Bank senderBank, Bank receiverBank,
			String receiverAccountHolderName, String receiverAccountHolderNumber, Transfertypes transferTypes,
			Message message, double currencyAmount, double transferFees, double inrAmount, Date date) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.currency = currency;
		this.senderBank = senderBank;
		this.receiverBank = receiverBank;
		this.receiverAccountHolderName = receiverAccountHolderName;
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
		this.transferTypes = transferTypes;
		this.message = message;
		this.currencyAmount = currencyAmount;
		this.transferFees = transferFees;
		this.inrAmount = inrAmount;
		this.date = date;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Bank getSenderBank() {
		return senderBank;
	}

	public void setSenderBank(Bank senderBank) {
		this.senderBank = senderBank;
	}

	public Bank getReceiverBank() {
		return receiverBank;
	}

	public void setReceiverBank(Bank receiverBank) {
		this.receiverBank = receiverBank;
	}

	public String getReceiverAccountHolderName() {
		return receiverAccountHolderName;
	}

	public void setReceiverAccountHolderName(String receiverAccountHolderName) {
		this.receiverAccountHolderName = receiverAccountHolderName;
	}

	public String getReceiverAccountHolderNumber() {
		return receiverAccountHolderNumber;
	}

	public void setReceiverAccountHolderNumber(String receiverAccountHolderNumber) {
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
	}

	public Transfertypes getTransferTypes() {
		return transferTypes;
	}

	public void setTransferTypes(Transfertypes transferTypes) {
		this.transferTypes = transferTypes;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public double getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(double currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	public double getTransferFees() {
		return transferFees;
	}

	public void setTransferFees(double transferFees) {
		this.transferFees = transferFees;
	}

	public double getInrAmount() {
		return inrAmount;
	}

	public void setInrAmount(double inrAmount) {
		this.inrAmount = inrAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", currency=" + currency
				+ ", senderBank=" + senderBank + ", receiverBank=" + receiverBank + ", receiverAccountHolderName="
				+ receiverAccountHolderName + ", receiverAccountHolderNumber=" + receiverAccountHolderNumber
				+ ", transferTypes=" + transferTypes + ", message=" + message + ", currencyAmount=" + currencyAmount
				+ ", transferFees=" + transferFees + ", inrAmount=" + inrAmount + ", date=" + date + "]";
	}

}
