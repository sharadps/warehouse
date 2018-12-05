package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ventab")
public class Vendor {
	@Id
	@GeneratedValue(generator = "vendor_gen")
	@GenericGenerator(name = "vendor_gen", strategy = "increment")
	@Column(name = "Ven_Id")
	private Integer venId;
	@Column(name = "Ven_Name")
	private String venName;
	@Column(name = "Ven_Code")
	private String venCode;
	@Column(name = "Ven_Desg")
	private String venDesg;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "venPreserve", joinColumns = @JoinColumn(name = "Ven_Id"))
	@Column(name = "data")
	@OrderColumn(name = "pos")
	private List<String> venPreserve;

	public Vendor() {
		super();
	}

	public Vendor(Integer venId) {
		super();
		this.venId = venId;
	}

	public Vendor(Integer venId, String venName, String venCode, String venDesg, List<String> venPreserve) {
		super();
		this.venId = venId;
		this.venName = venName;
		this.venCode = venCode;
		this.venDesg = venDesg;
		this.venPreserve = venPreserve;
	}

	public Integer getVenId() {
		return venId;
	}

	public void setVenId(Integer venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenDesg() {
		return venDesg;
	}

	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}

	public List<String> getVenPreserve() {
		return venPreserve;
	}

	public void setVenPreserve(List<String> venPreserve) {
		this.venPreserve = venPreserve;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venCode=" + venCode + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}

}
