
package com.javalec.dbaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.javalec.bean.coffeeBean_KMJ;
import com.javalec.bean.coffeeBean_KMJ2;
import com.javalec.sharevar.searchShareVar_KMJ;

/**
 * @FileName : coffeeSearchAction_KMJ.java
 * @Project : Project2
 * @Date : 2021. 4. 30.
 * @작성자 : gimminjae
 * @변경이력 :
 * @프로그램설명 : 메뉴리스트, 댓글리스트CRUD
 */
public class coffeeSearchAction_KMJ {

	private final String url_mysql = searchShareVar_KMJ.url_mysql;
	private final String id_mysql = searchShareVar_KMJ.id_mysql;
	private final String pw_mysql = searchShareVar_KMJ.pw_mysql;
	String brandName;
	String menuType;
	String menuName;
	String price;
	String comment;

	/**
	 * @Method Name : searchLisetInnertable
	 * @작성일 : 2021. 4. 30.
	 * @작성자 : gimminjae
	 * @변경이력 :
	 * @Method설명 : 메뉴리스트 초기화 SELECT
	 * @param beanData
	 * @return
	 */
	public ArrayList<coffeeBean_KMJ> searchLisetInnertable(coffeeBean_KMJ beanData) {
		ArrayList<coffeeBean_KMJ> beanList = new ArrayList<coffeeBean_KMJ>();
		PreparedStatement ps = null;
		String topic = "";
		if (beanData.getTopic().trim() == "메뉴타입") {
			topic = "menu.menuType";
		}
		if (beanData.getTopic().trim() == "메뉴명") {
			topic = "menu.menuName";
		}
		if (beanData.getTopic().trim() == "브랜드명") {
			topic = "brand.brandName";
		}
		if (beanData.getTopic().trim() == "가격") {
			topic = "menuUpdate.menuprice";
		}
		try {
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String select = "SELECT brand.brandName, menu.menuType, menu.menuName, menuUpdate.menuPrice \n";
			String from = "FROM coffee.menu, coffee.brand, coffee.menuUpdate\n";
			String where = "WHERE menu.brand_brandCode = brand.brandCode\n";
			String and1 = "and menu.menuCode = menuUpdate.menu_menuCode\n";
			String and2 = "and " + topic + " like ? \n";
			String orderBy = "order by " + topic;// 쿼리문 합치기 편하게 구분
			ps = conn_mysql.prepareStatement(select + from + where + and1 + and2 + orderBy); // 데이터베이스에 쿼리를 실행한 상태, 아직
			ps.setString(1, "%" + beanData.getSearchValue().trim() + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String selectBrandName = rs.getString(1);
				String selectMenuType = rs.getString(2);
				String selectMenuName = rs.getString(3);
				String selectMenuPrice = rs.getString(4);
				coffeeBean_KMJ bean = new coffeeBean_KMJ(selectBrandName, selectMenuType, selectMenuName,
						selectMenuPrice);
				beanList.add(bean);
			}
			conn_mysql.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return beanList;
	}

	/**
	 * @Method Name : commentLisetInnertable
	 * @작성일 : 2021. 4. 30.
	 * @작성자 : gimminjae
	 * @변경이력 :
	 * @Method설명 : 댓글리스트 초기화 SELECT
	 * @param beanData
	 * @return
	 */
	public ArrayList<coffeeBean_KMJ2> commentLisetInnertable(coffeeBean_KMJ2 beanData) {
		ArrayList<coffeeBean_KMJ2> beanList = new ArrayList<coffeeBean_KMJ2>();
		PreparedStatement ps = null;
		try {
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String select = "SELECT coffee.client.clientNick, coffee.comment.comment, coffee.comment.client_clientCode, coffee.comment.commentCode \n";
			String from = "FROM coffee.brand, coffee.menu, coffee.client, coffee.comment\n";
			String where = "WHERE coffee.comment.client_clientCode = coffee.client.clientCode\n";
			String and1 = "AND coffee.comment.menu_menuCode = coffee.menu.menuCode \n";
			String and2 = "AND coffee.comment.brand_brandCode = coffee.brand.brandCode\n";
			String and3 = "AND coffee.brand.brandName LIKE ? AND coffee.menu.menuName LIKE ?\n";
			String and4 = "AND commentOnOff = '1' \n";

			ps = conn_mysql.prepareStatement(select + from + where + and1 + and2 + and3 + and4); // 데이터베이스에 쿼리를 실행한 상태,
																									// 아직
			ps.setString(1, "%" + beanData.getBrandName().trim() + "%");
			ps.setString(2, "%" + beanData.getMenuName().trim() + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String commentClientName = rs.getString(1);
				String commentComment = rs.getString(2);
				String clientCode = rs.getString(3);
				String commentCode = rs.getString(4);
				coffeeBean_KMJ2 bean = new coffeeBean_KMJ2(commentClientName, commentComment, clientCode, commentCode);
				beanList.add(bean);
			}
			conn_mysql.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return beanList;
	}

	/**
	  * @Method Name : addCommend
	  * @작성일 : 2021. 4. 30.
	  * @작성자 : gimminjae
	  * @변경이력 : 
	  * @Method설명 : 댓글 달기 INSERT
	  * @param beanData
	  * @return
	  */
	public boolean addCommend(coffeeBean_KMJ2 beanData) {
		PreparedStatement selectps = null;
		PreparedStatement ps = null;
		try {
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			selectps = conn_mysql.prepareStatement(
					"select brand.brandCode, menu.menuCode from coffee.menu, coffee.brand where menu.brand_brandCode = brand.brandCode and brand.brandName = ? and menu.menuName = ?");
			selectps.setString(1, beanData.getBrandName());
			selectps.setString(2, beanData.getMenuName());
			ResultSet rs = selectps.executeQuery();
			if (rs.next()) {
				brandName = rs.getString(1);
				menuName = rs.getString(2);
			}
			String insert = "INSERT INTO coffee.comment (brand_brandCode, menu_menuCode, client_clientCode, coffee.comment.comment, commentDate, commentOnOff) ";
			String values1 = "VALUES (?, ?, ?, ?, now(), '1')";
			ps = conn_mysql.prepareStatement(insert + values1);
			ps.setString(1, brandName);
			ps.setString(2, menuName);
			ps.setString(3, beanData.getClientCode());
			ps.setString(4, beanData.getComment());
			ps.executeUpdate();
			conn_mysql.close();

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	/**
	 * @Method Name : commentUpdate
	 * @작성일 : 2021. 4. 30.
	 * @작성자 : gimminjae
	 * @변경이력 :
	 * @Method설명 : 댓글 수정 UPDATE
	 * @param beanData
	 * @return
	 */
	public boolean commentUpdate(coffeeBean_KMJ2 beanData) {
		PreparedStatement ps = null;
		try {
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String update = "Update coffee.comment set comment.comment = ? where comment.commentCode = ?";
			ps = conn_mysql.prepareStatement(update);
			ps.setString(1, beanData.getComment());
			ps.setString(2, beanData.getCommentCode());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	/**
	  * @Method Name : commentDelete
	  * @작성일 : 2021. 4. 30.
	  * @작성자 : gimminjae
	  * @변경이력 : 
	  * @Method설명 : 댓글 삭제 DELETE
	  * @param beanData
	  * @return
	  */
	public boolean commentDelete(coffeeBean_KMJ2 beanData) {
		PreparedStatement ps = null;
		try {
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String update = "Update coffee.comment set comment.commentOnOff = '0' where comment.commentCode = ?";
			ps = conn_mysql.prepareStatement(update);
			ps.setString(1, beanData.getCommentCode());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}


}
