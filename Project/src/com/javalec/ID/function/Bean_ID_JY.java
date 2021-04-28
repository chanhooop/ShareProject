package com.javalec.ID.function;

public class Bean_ID_JY {
	
	// field
	String name = "";
	String telno = ""; 
	
	
	// construction
	public Bean_ID_JY() {

	
	}


	public Bean_ID_JY(String name, String telno) {
		super();
		this.name = name;
		this.telno = telno;
	}

	// method (게터와 세터)

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTelno() {
		return telno;
	}


	public void setTelno(String telno) {
		this.telno = telno;
	}
	
	

} //-------------------------
