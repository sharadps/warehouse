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

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OrderModel {
	@Id
	@GeneratedValue(generator = "om_gen")
	@GenericGenerator(name = "om_gen", strategy = "increment")
	@Column(name = "OmId")
	private Integer omId;
	@Column(name = "OmModel")
	private String omModel;
	@Column(name = "OmCode")
	private String omCode;
	@Column(name = "OmMethod")
	private String omMethod;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "orderAccepttab", joinColumns = @JoinColumn(name = "omId"))
	@OrderColumn(name = "pos")
	@Column(name = "OmAccept")
	private List<String> omAcceptt;
	@Column(name = "OmDsc")
	private String omDsc;

	public OrderModel() {
		super();
	}

	public OrderModel(Integer omId) {
		super();
		this.omId = omId;
	}

	public OrderModel(Integer omId, String omModel, String omCode, String omMethod, List<String> omAcceptt,
			String omDsc) {
		super();
		this.omId = omId;
		this.omModel = omModel;
		this.omCode = omCode;
		this.omMethod = omMethod;
		this.omAcceptt = omAcceptt;
		this.omDsc = omDsc;
	}

	public Integer getOmId() {
		return omId;
	}

	public void setOmId(Integer omId) {
		this.omId = omId;
	}

	public String getOmModel() {
		return omModel;
	}

	public void setOmModel(String omModel) {
		this.omModel = omModel;
	}

	public String getOmCode() {
		return omCode;
	}

	public void setOmCode(String omCode) {
		this.omCode = omCode;
	}

	public String getOmMethod() {
		return omMethod;
	}

	public void setOmMethod(String omMethod) {
		this.omMethod = omMethod;
	}

	public List<String> getOmAcceptt() {
		return omAcceptt;
	}

	public void setOmAcceptt(List<String> omAcceptt) {
		this.omAcceptt = omAcceptt;
	}

	public String getOmDsc() {
		return omDsc;
	}

	public void setOmDsc(String omDsc) {
		this.omDsc = omDsc;
	}

	@Override
	public String toString() {
		return "OrderModel [omId=" + omId + ", omModel=" + omModel + ", omCode=" + omCode + ", omMethod=" + omMethod
				+ ", omAcceptt=" + omAcceptt + ", omDsc=" + omDsc + "]";
	}

}
