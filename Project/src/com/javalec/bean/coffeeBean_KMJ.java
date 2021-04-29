package com.javalec.bean;

public class coffeeBean_KMJ {
	String Topic;
	String searchValue;
	String brandName;
	String menuType;
	String menuName;
	String price;

	String clientName;
	String comment;
	String clientCode;

	public coffeeBean_KMJ(String client, String comment) {
		super();
		this.clientName = client;
		this.comment = comment;
	}

	public coffeeBean_KMJ() {
		// TODO Auto-generated constructor stub
	}

	public coffeeBean_KMJ(String brandName, String menuType, String menuName, String price) {
		super();
		this.brandName = brandName;
		this.menuType = menuType;
		this.menuName = menuName;
		this.price = price;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String Topic) {
		this.Topic = Topic;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
