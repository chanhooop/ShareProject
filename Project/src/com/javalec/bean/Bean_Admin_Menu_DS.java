package com.javalec.bean;

public class Bean_Admin_Menu_DS {
	int menu_menuCode;
	int menuCode;
	String brandName;
	String menuType;
	String menuName;
	String menuPrice;

	public Bean_Admin_Menu_DS(int menuCode, String brandName, String menuType, String menuName, String menuPrice) {
		super();
		this.menuCode = menuCode;
		this.brandName = brandName;
		this.menuType = menuType;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public Bean_Admin_Menu_DS() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMenu_menuCode() {
		return menu_menuCode;
	}

	public void setMenu_menuCode(int menu_menuCode) {
		this.menu_menuCode = menu_menuCode;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
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

	public String getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}

}
