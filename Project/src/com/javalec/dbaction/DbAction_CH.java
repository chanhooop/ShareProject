package com.javalec.dbaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.bean.Bean_CH;
import com.javalec.sharevar.ShareVar_CH;


public class DbAction_CH {

	// Field
	private final String url_mysql = ShareVar_CH.url_mysql;
	private final String id_mysql = ShareVar_CH.id_mysql;
	private final String pw_mysql = ShareVar_CH.pw_mysqll;

	// 칼럼 선언자
	int menucode;
	String brandName;
	String menuName;
	String menuprice;
	
	

	// constructor

	public DbAction_CH() {

	}




	public DbAction_CH(int menucode, String brandName, String menuName, String menuprice) {
		super();
		this.menucode = menucode;
		this.brandName = brandName;
		this.menuName = menuName;
		this.menuprice = menuprice;
	}

	
	
	public DbAction_CH(int menucode) {
	super();
	this.menucode = menucode;
}
	// method
	
	
	// 테이블에 데이터 불러오기
	public ArrayList<Bean_CH> selectList(){
		
		   ArrayList<Bean_CH> beanList = new ArrayList<Bean_CH>();  // 어레이리스트 타입의 생성자 만들어주기
		

		  String WhereDefault = "select m.menuCode, b.brandName, m.menuName, mu.menuprice from brand b, menu m, menuupdate mu where b.brandCode = m.brand_brandCode and m.menuCode = mu.menu_menuCode";
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	          while(rs.next()){
	        	  int menuCode = rs.getInt(1);
	        	  String brandName = rs.getString(2);
	        	  String menuName = rs.getString(3);
	        	  String menuprice = rs.getString(4);

	        	  Bean_CH bean_CH = new Bean_CH(menuCode, brandName, menuName, menuprice);
	        	  beanList.add(bean_CH);
	        	  
	          }
	          conn_mysql.close();
	       }
	       catch (Exception e){
	          e.printStackTrace();
	      }
		return beanList;
	      
	  }
		
	
	// 테이블에 데이터 하나 클릭하면 나타나게 만들기
	public Bean_CH tableClick(String mCode) {
		Bean_CH bean_CH = null;

		String query1 = "select m.menuCode, b.brandName, m.menuName, mu.menuprice, mt.materialAllergy from menu m, brand b, material mt, menuupdate mu ";
		String query2 = "where b.brandCode = m.brand_brandCode and m.menuCode = mt.menu_menuCode and m.menuCode = mu.menu_menuCode and m.menuCode = ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2 + mCode);
			
			if(rs.next()) {									
				int tfmenuCode = rs.getInt(1);  		   
				String tfmenuprice = rs.getString(2);  	
				String tfbrandName = rs.getString(3);  		   
				String tfmenuName = rs.getString(4);  		   
				String tfmeterial = rs.getString(5);
				bean_CH = new Bean_CH(tfmenuCode, tfmenuprice, tfbrandName, tfmenuName, tfmeterial);
			}
			
			conn_mysql.close();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bean_CH;	
	}
	
	//********************************조건 검색 부분******************************************************************

	// 콤보상자 선택으로 조건검색 
	public ArrayList<Bean_CH> conditionQueryDb(Bean_CH beanget){
		
		ArrayList<Bean_CH> bean_CH = new ArrayList<Bean_CH>();
				
		String query1 = "select m.menuCode, b.brandName, m.menuName, mu.menuPrice from menu m, brand b, menuupdate mu where  b.brandCode = m.brand_brandCode and m.menuCode = mu.menu_menuCode and " + beanget.getConditionQueryColumn();
		String query2 = " like '%" + beanget.getTfsearch() + "%' ";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			
			while(rs.next()) {
				
				int tfmenuCode = rs.getInt(1);
				String tfbrandName = rs.getString(2);
				String tfmenuName = rs.getString(3);
				String tfmenuPrice = rs.getString(4);
				Bean_CH conditonBean = new Bean_CH(tfmenuCode, tfbrandName, tfmenuName, tfmenuPrice);
				bean_CH.add(conditonBean);
									
			}
			conn_mysql.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return bean_CH;
	}
	
	
	// 가격선택시 콤보상자 검색
	
	public ArrayList<Bean_CH> priceconditionQueryDB(Bean_CH beanget) {
			
		int i = beanget.getCmbPriceSelect();    // 몇번째인지 알아봐주는 메서드 겟셀렉티드 인덱스
				
		String conditionPriceColumn = "";
		switch(i) {
		case 0 : 
			conditionPriceColumn = " mu.menuPrice > '0' ";
			break;
		case 1 : 
			conditionPriceColumn = " mu.menuPrice between '1,000' and '3,000' ";

			break;
		case 2 : 
			conditionPriceColumn = " mu.menuPrice between '3,000' and '6,000' ";
			break;
		case 3 : 
			conditionPriceColumn = " mu.menuPrice between '6,000' and '9,000' ";
			break;
		default : 
			break;
		
		}

		ArrayList<Bean_CH> bean_CH = new ArrayList<Bean_CH>();
		
		String query1 = "select m.menuCode, b.brandName, m.menuName, mu.menuPrice from menu m, brand b, menuupdate mu where  b.brandCode = m.brand_brandCode and m.menuCode = mu.menu_menuCode and" + conditionPriceColumn;

		System.out.println(query1);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();	
			
			ResultSet rs = stmt_mysql.executeQuery(query1);
			
			while(rs.next()) {
			
				int tfmenuCode = rs.getInt(1);
				String tfbrandName = rs.getString(2);
				String tfmenuName = rs.getString(3);
				String tfmenuPrice = rs.getString(4);
				Bean_CH conditonBean = new Bean_CH(tfmenuCode, tfbrandName, tfmenuName, tfmenuPrice);
				bean_CH.add(conditonBean);

			}
			conn_mysql.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		return bean_CH;
	}
//  **************************************************************************************************************	
	
	
}//----------------------------------------------------------------------------
