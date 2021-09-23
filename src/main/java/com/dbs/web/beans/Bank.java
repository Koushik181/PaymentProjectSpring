package com.dbs.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank implements Serializable {

	@Id
	private String bic;
	@Column(name = "bankname")
	private String bankName;
	
	
	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankName=" + bankName + "]";
	}
	public Bank(String bic, String bankName) {
		super();
		this.bic = bic;
		this.bankName = bankName;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Bank() {
		System.out.println("bank def constructor");
		// TODO Auto-generated constructor stub
	}

}
