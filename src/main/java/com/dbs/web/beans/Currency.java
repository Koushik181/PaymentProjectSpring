package com.dbs.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency implements Serializable {

	@Id
	@Column(name = "currencycode")
	private String currencyCode;
	@Column(name = "currencyname")
	private String currencyName;
	
	
	
	@Override
	public String toString() {
		return "Currency [currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", conversionRate="
				+ conversionRate + "]";
	}
	public Currency(String currencyCode, String currencyName, String conversionRate) {
		super();
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.conversionRate = conversionRate;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}
	@Column(name = "conversionrate")
	private String conversionRate;
	public Currency() {
		// TODO Auto-generated constructor stub
	}

}
