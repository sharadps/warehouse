package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "custtab")
public class Customer {
	@Id
	@GeneratedValue(generator = "customer_gen")
	@GenericGenerator(name = "customer_gen", strategy = "increment")
	@Column(name = "Cust_Id")
	private Integer custId;
	@Column(name = "Cust_COde")
	private String custCode;
	
	@Column(name = "Cust_Address")
	private String custAddress;
	@Column(name = "Cust_Location")
	private String custLocs;
	@Column(name = "Cust_Enabled")
	private String custEnabled;
	@Column(name = "Cust_Email")
	private String custEmail;
	@Column(name = "Cust_Contact")
	private String custContact;

	public Customer() {
		super();
	}

	public Customer(Integer custId) {
		super();
		this.custId = custId;
	}

	public Customer(Integer custId, String custCode, String custAddress, String custLocs, String custEnabled,
			String custEmail, String custContact) {
		super();
		this.custId = custId;
		this.custCode = custCode;
		this.custAddress = custAddress;
		this.custLocs = custLocs;
		this.custEnabled = custEnabled;
		this.custEmail = custEmail;
		this.custContact = custContact;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustLocs() {
		return custLocs;
	}

	public void setCustLocs(String custLocs) {
		this.custLocs = custLocs;
	}

	public String getCustEnabled() {
		return custEnabled;
	}

	public void setCustEnabled(String custEnabled) {
		this.custEnabled = custEnabled;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCode=" + custCode + ", custAddress=" + custAddress + ", custLocs="
				+ custLocs + ", custEnabled=" + custEnabled + ", custEmail=" + custEmail + ", custContact="
				+ custContact + "]";
	}

}
