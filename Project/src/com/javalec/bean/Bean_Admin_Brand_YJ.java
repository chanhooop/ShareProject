package com.javalec.bean;

public class Bean_Admin_Brand_YJ {
	
	int brandCode;
	String brandName;
	
	public Bean_Admin_Brand_YJ() {
		// TODO Auto-generated constructor stub
	}
	



	public Bean_Admin_Brand_YJ(int brandCode, String brandName) {
		super();
		this.brandCode = brandCode;
		this.brandName = brandName;
	}


	public int getBrandCode() {
		return brandCode;
	}


	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
	
}
