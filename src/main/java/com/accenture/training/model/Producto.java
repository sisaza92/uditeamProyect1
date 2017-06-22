package com.accenture.training.model;

public class Producto {
	
	private Integer intIdProduct = 0;
	private String strDescription = "";
	private Integer intNmbrOfPeople = 0;
	private Integer intProductType = 0;
	
	
	public Producto() {

	}


	public Producto(Integer intIdProduct, String strDescription, Integer intNmbrOfPeople, Integer intProductType) {
		super();
		this.intIdProduct = intIdProduct;
		this.strDescription = strDescription;
		this.intNmbrOfPeople = intNmbrOfPeople;
		this.intProductType = intProductType;
	}


	public Integer getIntIdProduct() {
		return intIdProduct;
	}


	public void setIntIdProduct(Integer intIdProduct) {
		this.intIdProduct = intIdProduct;
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
	
	
	
}
