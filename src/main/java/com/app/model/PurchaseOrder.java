package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "purchase_Order_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator = "po_gen")
	@GenericGenerator(name = "po_gen", strategy = "increment")
	@Column(name = "PO_Id")
	private Integer purchaseId;
	@Column(name = "PO_Code")
	private String purchaseCode;

	@ManyToOne
	@JoinColumn(name = "shipcode_Fk")
	private ShipmentType purchaseshipCode;

	@ManyToOne
	@JoinColumn(name = "whuser_Fk")
	private WhUserType purchaseVendor;

	@Column(name = "PO_RefNumber")
	private String purchaseRefno;
	@Column(name = "PO_QuickCheck")
	private String purchaseQcheck;
	@Column(name = "PO_DefaultStatus")
	private String purchaseDefStatus;
	@Column(name = "PO_Dsc")
	private String purchaseDsc;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}

	public PurchaseOrder(Integer purchaseId, String purchaseCode, ShipmentType purchaseshipCode,
			WhUserType purchaseVendor, String purchaseRefno, String purchaseQcheck, String purchaseDefStatus,
			String purchaseDsc) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseCode = purchaseCode;
		this.purchaseshipCode = purchaseshipCode;
		this.purchaseVendor = purchaseVendor;
		this.purchaseRefno = purchaseRefno;
		this.purchaseQcheck = purchaseQcheck;
		this.purchaseDefStatus = purchaseDefStatus;
		this.purchaseDsc = purchaseDsc;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public ShipmentType getPurchaseshipCode() {
		return purchaseshipCode;
	}

	public void setPurchaseshipCode(ShipmentType purchaseshipCode) {
		this.purchaseshipCode = purchaseshipCode;
	}

	public WhUserType getPurchaseVendor() {
		return purchaseVendor;
	}

	public void setPurchaseVendor(WhUserType purchaseVendor) {
		this.purchaseVendor = purchaseVendor;
	}

	public String getPurchaseRefno() {
		return purchaseRefno;
	}

	public void setPurchaseRefno(String purchaseRefno) {
		this.purchaseRefno = purchaseRefno;
	}

	public String getPurchaseQcheck() {
		return purchaseQcheck;
	}

	public void setPurchaseQcheck(String purchaseQcheck) {
		this.purchaseQcheck = purchaseQcheck;
	}

	public String getPurchaseDefStatus() {
		return purchaseDefStatus;
	}

	public void setPurchaseDefStatus(String purchaseDefStatus) {
		this.purchaseDefStatus = purchaseDefStatus;
	}

	public String getPurchaseDsc() {
		return purchaseDsc;
	}

	public void setPurchaseDsc(String purchaseDsc) {
		this.purchaseDsc = purchaseDsc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", purchaseCode=" + purchaseCode + ", purchaseshipCode="
				+ purchaseshipCode + ", purchaseVendor=" + purchaseVendor + ", purchaseRefno=" + purchaseRefno
				+ ", purchaseQcheck=" + purchaseQcheck + ", purchaseDefStatus=" + purchaseDefStatus + ", purchaseDsc="
				+ purchaseDsc + "]";
	}

}
