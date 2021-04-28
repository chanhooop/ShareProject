package com.javalec.bean;
//asdfasdfasdfasdf
//asdfdsfdf
public class Bean {

	// field
	
	int menuCode;
	int brandCode;
	String menuprice;
	String brandName;
	String menuName;
	String materialAllerge;
	String tfsearch;
	String conditionQueryColumn;
	int cmbPriceSelect;
	
	//constructor
	
	public Bean() {
		
	}



	// 테이블에 데이터 클릭하면 나타나게 만들기
	public Bean(int menuCode, String menuprice, String brandName, String menuName, String materialAllerge) {
		super();
		this.menuCode = menuCode;
		this.menuprice = menuprice;
		this.brandName = brandName;
		this.menuName = menuName;
		this.materialAllerge = materialAllerge;
	}


	// 테이블에 데이터 불러오기  // 조건검색
	public Bean(int menuCode,  String brandName, String menuName, String menuprice) {
		super();
		this.menuCode = menuCode;
		this.brandName = brandName;
		this.menuName = menuName;
		this.menuprice = menuprice;
	}

	

	
	// method



	public int getMenuCode() {
		return menuCode;
	}



	public int getCmbPriceSelect() {
		return cmbPriceSelect;
	}



	public void setCmbPriceSelect(int cmbPriceSelect) {
		this.cmbPriceSelect = cmbPriceSelect;
	}



	public String getConditionQueryColumn() {
		return conditionQueryColumn;
	}



	public void setConditionQueryColumn(String conditionQueryColumn) {
		this.conditionQueryColumn = conditionQueryColumn;
	}



	public String getTfsearch() {
		return tfsearch;
	}



	public void setTfsearch(String tfsearch) {
		this.tfsearch = tfsearch;
	}



	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}



	public int getBrandCode() {
		return brandCode;
	}



	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}



	public String getmenuprice() {
		return menuprice;
	}



	public void setmenuprice(String menuprice) {
		this.menuprice = menuprice;
	}



	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}



	public String getMenuName() {
		return menuName;
	}



	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public String getMetarialName() {
		return materialAllerge;
	}


	public void setmaterialAllerge(String materialAllerge) {
		this.materialAllerge = materialAllerge;
	}
	
	
	
}
