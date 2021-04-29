package com.javalec.dbaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.bean.Bean_Login_YJ;
import com.javalec.sharevar.ShareVar_Login_YJ;

public class DbAction_Login_YJ {
	private final String url_mysql = ShareVar_Login_YJ.url_mysql;
	private final String id_mysql = ShareVar_Login_YJ.id_mysql;
	private final String pw_mysql = ShareVar_Login_YJ.pw_mysql;
	
	
	private String clientId;
	private String clientPw;
	private String clientName;
	
	private String adminId;
	private String adminPw;
	
	
	public DbAction_Login_YJ(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public DbAction_Login_YJ(String clientId, String clientPw, String clientName) {
		super();
		this.clientId = clientId;
		this.clientPw = clientPw;
		this.clientName = clientName;
	}
	
	public Bean_Login_YJ clientRoginAction() {
		Bean_Login_YJ bean = null;
		String wkId = "";
		String wkPw = "";
		String wkName = "";
		try {
			String query = "select clientId, clientPw, clientName from client where clientId = '" + clientId
					+ "' and clientPw = '" + clientPw + "'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query);

			if (rs.next()) {
				wkId = rs.getString(1);
				wkPw = rs.getString(2);
				wkName = rs.getString(3);
			}
			bean = new Bean_Login_YJ(wkId, wkPw, wkName);
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	public Bean_Login_YJ adminRoginAction() {
		String wkId = "";
		String wkPw = "";
		Bean_Login_YJ bean = null;
		String query = "select adminId, adminPw from admin where adminId = '" + adminId + "' and adminPw = '" + adminPw + "'";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(query);

				if (rs.next()) {
					wkId = rs.getString(1);
					wkPw = rs.getString(2);
				}
				bean = new Bean_Login_YJ(wkId, wkPw);
				conn_mysql.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
	}
	
}
