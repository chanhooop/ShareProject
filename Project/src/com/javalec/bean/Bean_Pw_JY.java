package com.javalec.bean;

public class Bean_Pw_JY {
	
	// field
	String id = "";
	String name = "";
	String telno = "";

	
	// construction
	public Bean_Pw_JY() {

		
	}


	public Bean_Pw_JY(String id, String name, String telno) {
		super();
		this.id = id;
		this.name = name;
		this.telno = telno;
	}


	// method (게터와 세터)
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


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
	

	

}
