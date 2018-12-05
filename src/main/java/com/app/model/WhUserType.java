package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class WhUserType {
	@Id
	@GeneratedValue(generator = "whuser_gen")
	@GenericGenerator(name = "whuser_gen", strategy = "increment")
	@Column(name = "WhId")
	private Integer whId;
	@Column(name = "WhType")
	private String whType;
	@Column(name = "WhCode")
	private String whCode;
	@Column(name = "WhForType")
	private String whForType;
	@Column(name = "WhEmail")
	private String whEmail;
	@Column(name = "WhContact")
	private String whContact;
	@Column(name = "WhIdType")
	private String whIdType;
	@Column(name = "WhIfOther")
	private String whIfOther;
	@Column(name = "WhIdNumber")
	private String whIdNumber;

	public WhUserType() {
		super();
	}

	public WhUserType(Integer whId) {
		super();
		this.whId = whId;
	}

	public WhUserType(Integer whId, String whType, String whCode, String whForType, String whEmail, String whContact,
			String whIdType, String whIfOther, String whIdNumber) {
		super();
		this.whId = whId;
		this.whType = whType;
		this.whCode = whCode;
		this.whForType = whForType;
		this.whEmail = whEmail;
		this.whContact = whContact;
		this.whIdType = whIdType;
		this.whIfOther = whIfOther;
		this.whIdNumber = whIdNumber;
	}

	public Integer getWhId() {
		return whId;
	}

	public void setWhId(Integer whId) {
		this.whId = whId;
	}

	public String getWhType() {
		return whType;
	}

	public void setWhType(String whType) {
		this.whType = whType;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getWhForType() {
		return whForType;
	}

	public void setWhForType(String whForType) {
		this.whForType = whForType;
	}

	public String getWhEmail() {
		return whEmail;
	}

	public void setWhEmail(String whEmail) {
		this.whEmail = whEmail;
	}

	public String getWhContact() {
		return whContact;
	}

	public void setWhContact(String whContact) {
		this.whContact = whContact;
	}

	public String getWhIdType() {
		return whIdType;
	}

	public void setWhIdType(String whIdType) {
		this.whIdType = whIdType;
	}

	public String getWhIfOther() {
		return whIfOther;
	}

	public void setWhIfOther(String whIfOther) {
		this.whIfOther = whIfOther;
	}

	public String getWhIdNumber() {
		return whIdNumber;
	}

	public void setWhIdNumber(String whIdNumber) {
		this.whIdNumber = whIdNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [whId=" + whId + ", whType=" + whType + ", whCode=" + whCode + ", whForType=" + whForType
				+ ", whEmail=" + whEmail + ", whContact=" + whContact + ", whIdType=" + whIdType + ", whIfOther="
				+ whIfOther + ", whIdNumber=" + whIdNumber + "]";
	}

}
