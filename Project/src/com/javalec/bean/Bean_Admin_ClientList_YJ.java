package com.javalec.bean;

public class Bean_Admin_ClientList_YJ {
	// field
//	clientId, clientPw, clientName, clientTelno, clientNick
	int clientCode;
	String clientId;
	String clientPw;
	String clientName;
	String clientTelno;
	String clientNick;
	String adminId;
	String adminPw;

	// constructor
	public Bean_Admin_ClientList_YJ(int clientCode, String clientId, String clientName, String clientTelno, String clientNick) {
		super();
		this.clientCode = clientCode;
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientTelno = clientTelno;
		this.clientNick = clientNick;
	}

	public Bean_Admin_ClientList_YJ(int clientCode, String clientId, String clientPw, String clientName, String clientTelno,
			String clientNick) {
		super();
		this.clientCode = clientCode;
		this.clientId = clientId;
		this.clientPw = clientPw;
		this.clientName = clientName;
		this.clientTelno = clientTelno;
		this.clientNick = clientNick;
	}

	public Bean_Admin_ClientList_YJ(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

//
//	public Bean(String clientId, String clientPw) {
//		super();
//		this.clientId = clientId;
//		this.clientPw = clientPw;
//	}

	// method

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientPw() {
		return clientPw;
	}

	public void setClientPw(String clientPw) {
		this.clientPw = clientPw;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientTelno() {
		return clientTelno;
	}

	public void setClientTelno(String clientTelno) {
		this.clientTelno = clientTelno;
	}

	public String getClientNick() {
		return clientNick;
	}

	public void setClientNick(String clientNick) {
		this.clientNick = clientNick;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

}
