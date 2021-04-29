package com.javalec.dbaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.bean.Bean_Admin_Brand_YJ;
import com.javalec.sharevar.ShareVar_Admin_Brand_YJ;

public class DbAction_Admin_Brand_YJ {

	private final String url_mysql = ShareVar_Admin_Brand_YJ.DBName;
	private final String id_mysql = ShareVar_Admin_Brand_YJ.DBUser;
	private final String pw_mysql = ShareVar_Admin_Brand_YJ.DBPass;

	FileInputStream file;
	private int brandCode;
	private String brandName;
	private String brandLogo;

	public DbAction_Admin_Brand_YJ() {
		// TODO Auto-generated constructor stub
	}

	
	public DbAction_Admin_Brand_YJ(String brandName, FileInputStream file, int brandCode) {
		super();
		this.file = file;
		this.brandCode = brandCode;
		this.brandName = brandName;
	}


	public DbAction_Admin_Brand_YJ(String brandName, String brandLogo) {
		super();
		this.brandName = brandName;
		this.brandLogo = brandLogo;
	}


	public DbAction_Admin_Brand_YJ(String brandName, FileInputStream file) {
		super();
		this.file = file;
		this.brandName = brandName;
	}

	public DbAction_Admin_Brand_YJ(int brandCode) {
		super();
		this.brandCode = brandCode;
	}

	public ArrayList<Bean_Admin_Brand_YJ> SelectList() {
		ArrayList<Bean_Admin_Brand_YJ> BeanList = new ArrayList<Bean_Admin_Brand_YJ>();

		String WhereDefault = "select brandCode, brandName from brand";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

			while (rs.next()) {

				int brandCode = rs.getInt(1);
				String brandName = rs.getString(2);

				Bean_Admin_Brand_YJ bean = new Bean_Admin_Brand_YJ(brandCode, brandName);
				BeanList.add(bean);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BeanList;
	}

	public boolean insertBrand() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query1 = "insert into brand (brandName, brandLogo)";
			String query2 = " values (?, ?)";

			ps = conn_mysql.prepareStatement(query1 + query2);

			ps.setString(1, brandName);
			ps.setBinaryStream(2, file);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Bean_Admin_Brand_YJ tableClick() {
		Bean_Admin_Brand_YJ bean = null;
		String WhereDefault = "select brandCode, brandName, brandLogo from brand ";
		String WhereDefault2 = "where brandCode = " + brandCode;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

			if (rs.next()) {

				int brandCode = rs.getInt(1);
				String brandName = rs.getString(2);

				// File
				ShareVar_Admin_Brand_YJ.filename = ShareVar_Admin_Brand_YJ.filename + 1;
				File file = new File(Integer.toString(ShareVar_Admin_Brand_YJ.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(3);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				bean = new Bean_Admin_Brand_YJ(brandCode, brandName);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}
	
	
	public Bean_Admin_Brand_YJ cencelInfo(int selected) {
		Bean_Admin_Brand_YJ bean = null;
		String WhereDefault = "select brandCode, brandName, brandLogo from brand ";
		String WhereDefault2 = "where brandCode = " + selected;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

			if (rs.next()) {

				int brandCode = rs.getInt(1);
				String brandName = rs.getString(2);

				// File
				ShareVar_Admin_Brand_YJ.filename = ShareVar_Admin_Brand_YJ.filename + 1;
				File file = new File(Integer.toString(ShareVar_Admin_Brand_YJ.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(3);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				bean = new Bean_Admin_Brand_YJ(brandCode, brandName);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}
	
	
	
	public boolean editAction() {
		
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
//			brand brandName brandLogo

			String A = "update brand set brandName = ?, brandLogo = ? ";
			String B = "where brandCode = ?";

			ps = conn_mysql.prepareStatement(A + B);

			ps.setString(1, brandName);
			ps.setBinaryStream(2, file);
			ps.setInt(3, brandCode);
			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
		
		
	}

}
