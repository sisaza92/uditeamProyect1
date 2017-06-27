package com.accenture.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tblProduct")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="intId")
	private Integer intId = 0;
	@Column(name="strName")
	private String strName;
	@Column(name="strDescription")
	private String strDescription = "";
	@Column(name="intNmbrOfPeople")
	private Integer intNmbrOfPeople = 0;
	@Column(name="intType")
	private Integer intProductType = 0;
	@Column(name="blnIsActive")
	private Boolean blnIsActive = false;
	
	
	public Product() {

	}

	

	public Product(Integer intId, String strName, String strDescription, Integer intNmbrOfPeople,
			Integer intProductType, Boolean blnIsActive) {
		super();
		this.intId = intId;
		this.strName = strName;
		this.strDescription = strDescription;
		this.intNmbrOfPeople = intNmbrOfPeople;
		this.intProductType = intProductType;
		this.blnIsActive = blnIsActive;
	}



	public Integer getIntId() {
		return intId;
	}


	public void setIntId(Integer intId) {
		this.intId = intId;
	}


	public String getStrName() {
		return strName;
	}


	public void setStrName(String strName) {
		this.strName = strName;
	}


	public String getStrDescription() {
		return strDescription;
	}


	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}


	public Integer getIntNmbrOfPeople() {
		return intNmbrOfPeople;
	}


	public void setIntNmbrOfPeople(Integer intNmbrOfPeople) {
		this.intNmbrOfPeople = intNmbrOfPeople;
	}


	public Integer getIntProductType() {
		return intProductType;
	}


	public void setIntProductType(Integer intProductType) {
		this.intProductType = intProductType;
	}


	public Boolean getBlnIsActive() {
		return blnIsActive;
	}


	public void setBlnIsActive(Boolean blnIsActive) {
		this.blnIsActive = blnIsActive;
	}
	
	
	
}
