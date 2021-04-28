package com.javalec.ID.function;

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
	
	String name = "";
	String telno = ""; 
	
	
	// construction
	public DbAction() {
	
		
	}
	
	public DbAction(String name, String telno) {
		super();
		this.name = name;
		this.telno = telno;
	}




	// -----------------------------
	// Method
	// -----------------------------

	
	// OK_btnOK
	public String okAction() {
		
		PreparedStatement ps = null;

		String findClientId = "";  		// 초기화 선언
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();	
			
			String query = "select clientId from client where clientName='" + name;
			String query2 = "' and clientTelno = '" + telno + "'";
			
			ResultSet rs = stmt_mysql.executeQuery(query + query2);		
			
			while(rs.next()) {     // rs.next는 데이터베이스에 있는 값을 불러온다.
				
				findClientId = rs.getString(1);
				
			}
			
			conn_mysql.isClosed();
			
			if(findClientId.equals("") ) {
				
				findClientId = "no";
				
			}
		 
		}catch(Exception e) {
			e.printStackTrace();	
		}
		
		return findClientId;
	}

} //----------------------------
