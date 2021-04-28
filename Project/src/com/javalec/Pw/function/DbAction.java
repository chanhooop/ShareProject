package com.javalec.Pw.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbAction {
	
	// field
	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id = "";
	String name = "";
	String telno = "";
	
	
	// construction
	public DbAction() {
		
//		super(); : 상속 받을 때 쓰는 것 즉, this와 같은 의미
	}


	public DbAction(String id, String name, String telno) {
		super();
		this.id = id;
		this.name = name;
		this.telno = telno;
	}
	
	
	
	// -----------------------------
	// Method
	// -----------------------------
	
	
	// OK_btnOK
	public String okAction() {
		
		PreparedStatement ps = null;

		String findClientPw = "";  // 초기화 선언
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();	
			
			String query = "select clientPw from client where clientId ='" + id;
			String query2 = "' and clientName = '" + name;
			String query3 = "' and clientTelno = '" + telno + "'";
			
			ResultSet rs = stmt_mysql.executeQuery(query + query2 + query3);	
			
			while(rs.next()) {     // rs.next는 데이터베이스에 있는 값을 불러온다.
				
				findClientPw = rs.getString(1);
			}
			
			conn_mysql.isClosed();
			
			if(findClientPw.equals("")) {
				
				findClientPw = "no";
				
			}
				
		}catch(Exception e) {
			e.printStackTrace();				
		}
		
		return findClientPw;
	
	}
	
	
	
	
	

} // ----------------------
