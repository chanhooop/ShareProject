package com.javalec.bean;

/**
  * @FileName : coffeeBean_KMJ2.java
  * @Project : Project2
  * @Date : 2021. 4. 30. 
  * @작성자 : gimminjae
  * @변경이력 :
  * @프로그램설명 : 코멘트 불러오는 빈
  */
public class coffeeBean_KMJ2 {

	String brandName;
	String menuType;
	String menuName;
	String clientCode;
	String clientName;
	String comment;
	String commentCode;

	public coffeeBean_KMJ2(String client, String comment, String clientCode, String commentCode) {
		super();
		this.clientName = client;
		this.comment = comment;
		this.clientCode = clientCode;
		this.commentCode = commentCode;
	}

	public coffeeBean_KMJ2() {
		// TODO Auto-generated constructor stub
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
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

}
