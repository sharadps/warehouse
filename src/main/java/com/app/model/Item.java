package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "itemtab")
public class Item {
	@Id
	@GeneratedValue(generator = "item_gen")
	@GenericGenerator(name = "item_gen", strategy = "increment")
	@Column(name = "Item_Id")
	private Integer iId;

	@Column(name = "Item_Code")
	private String itemCode;

	@Column(name = "Width")
	private String iWidth;

	@Column(name = "Lenght")
	private String iLength;

	@Column(name = "Height")
	private String iHeight;

	@Column(name = "Base_Cost")
	private String iBaseCost;

	@Column(name = "Currency")
	private String iCurrency;

	@ManyToOne
	@JoinColumn(name = "uidFk")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name = "omsaleFk")
	private OrderModel omSaleType;

	@ManyToOne
	@JoinColumn(name = "omPurchaseFk")
	private OrderModel omPurchaseType;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Item_VenUsers_tab", joinColumns = @JoinColumn(name = "itemIdFk"), inverseJoinColumns = @JoinColumn(name = "venIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	public List<WhUserType> venUsers = new ArrayList<WhUserType>(0);

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Item_Custuser_tab", joinColumns = @JoinColumn(name = "itemIdFk"), inverseJoinColumns = @JoinColumn(name = "custIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	public List<WhUserType> custUsers = new ArrayList<WhUserType>(0);

	public Item() {
		super();
	}

	public Item(Integer iId) {
		super();
		this.iId = iId;
	}

	public Item(Integer iId, String itemCode, String iWidth, String iLength, String iHeight, String iBaseCost,
			String iCurrency, Uom uom, OrderModel omSaleType, OrderModel omPurchaseType, List<WhUserType> venUsers,
			List<WhUserType> custUsers) {
		super();
		this.iId = iId;
		this.itemCode = itemCode;
		this.iWidth = iWidth;
		this.iLength = iLength;
		this.iHeight = iHeight;
		this.iBaseCost = iBaseCost;
		this.iCurrency = iCurrency;
		this.uom = uom;
		this.omSaleType = omSaleType;
		this.omPurchaseType = omPurchaseType;
		this.venUsers = venUsers;
		this.custUsers = custUsers;
	}

	public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getiWidth() {
		return iWidth;
	}

	public void setiWidth(String iWidth) {
		this.iWidth = iWidth;
	}

	public String getiLength() {
		return iLength;
	}

	public void setiLength(String iLength) {
		this.iLength = iLength;
	}

	public String getiHeight() {
		return iHeight;
	}

	public void setiHeight(String iHeight) {
		this.iHeight = iHeight;
	}

	public String getiBaseCost() {
		return iBaseCost;
	}

	public void setiBaseCost(String iBaseCost) {
		this.iBaseCost = iBaseCost;
	}

	public String getiCurrency() {
		return iCurrency;
	}

	public void setiCurrency(String iCurrency) {
		this.iCurrency = iCurrency;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderModel getOmSaleType() {
		return omSaleType;
	}

	public void setOmSaleType(OrderModel omSaleType) {
		this.omSaleType = omSaleType;
	}

	public OrderModel getOmPurchaseType() {
		return omPurchaseType;
	}

	public void setOmPurchaseType(OrderModel omPurchaseType) {
		this.omPurchaseType = omPurchaseType;
	}

	public List<WhUserType> getVenUsers() {
		return venUsers;
	}

	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}

	public List<WhUserType> getCustUsers() {
		return custUsers;
	}

	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}

	@Override
	public String toString() {
		return "Item [iId=" + iId + ", itemCode=" + itemCode + ", iWidth=" + iWidth + ", iLength=" + iLength
				+ ", iHeight=" + iHeight + ", iBaseCost=" + iBaseCost + ", iCurrency=" + iCurrency + ", uom=" + uom
				+ ", omSaleType=" + omSaleType + ", omPurchaseType=" + omPurchaseType + ", venUsers=" + venUsers
				+ ", custUsers=" + custUsers + "]";
	}

	

}
