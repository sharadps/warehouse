package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shiptab")
public class ShipmentType {
	@Id
	@GeneratedValue(generator = "ship_gen")
	@GenericGenerator(name = "ship_gen", strategy = "increment")
	@Column(name = "ShipId")
	private Integer shipId;
	@Column(name = "ShipMode")
	private String shipMode;
	@Column(name = "ShipCode")
	private String shipCode;
	@Column(name = "shipEnabled")
	private String shipEnabled;
	@Column(name = "ShipGrade")
	private String shipGrade;
	@Column(name = "ShipDSC")
	private String shipDsc;

	public ShipmentType() {
		super();
	}

	public ShipmentType(Integer shipId) {
		super();
		this.shipId = shipId;
	}

	public ShipmentType(Integer shipId, String shipMode, String shipCode, String shipEnabled, String shipGrade,
			String shipDsc) {
		super();
		this.shipId = shipId;
		this.shipMode = shipMode;
		this.shipCode = shipCode;
		this.shipEnabled = shipEnabled;
		this.shipGrade = shipGrade;
		this.shipDsc = shipDsc;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public String getShipEnabled() {
		return shipEnabled;
	}

	public void setShipEnabled(String shipEnabled) {
		this.shipEnabled = shipEnabled;
	}

	public String getShipGrade() {
		return shipGrade;
	}

	public void setShipGrade(String shipGrade) {
		this.shipGrade = shipGrade;
	}

	public String getShipDsc() {
		return shipDsc;
	}

	public void setShipDsc(String shipDsc) {
		this.shipDsc = shipDsc;
	}

	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipCode=" + shipCode + ", shipEnabled="
				+ shipEnabled + ", shipGrade=" + shipGrade + ", shipDsc=" + shipDsc + "]";
	}

}
