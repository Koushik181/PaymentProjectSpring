package com.dbs.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transfertypes implements Serializable{
	
	@Id
	@Column(name = "transfertypecode")
	private String transferTypeCode;
	@Column(name = "transfertypedescription")
	private String transferTypeDescription;
	public Transfertypes() {
		// TODO Auto-generated constructor stub
	}
	public Transfertypes(String transferTypeCode, String transferTypeDescription) {
		super();
		this.transferTypeCode = transferTypeCode;
		this.transferTypeDescription = transferTypeDescription;
	}
	public String getTransferTypeCode() {
		return transferTypeCode;
	}
	public void setTransferTypeCode(String transferTypeCode) {
		this.transferTypeCode = transferTypeCode;
	}
	public String getTransferTypeDescription() {
		return transferTypeDescription;
	}
	public void setTransferTypeDescription(String transferTypeDescription) {
		this.transferTypeDescription = transferTypeDescription;
	}
	@Override
	public String toString() {
		return "TransferTypes [transferTypeCode=" + transferTypeCode + ", transferTypeDescription="
				+ transferTypeDescription + "]";
	}
	

}
