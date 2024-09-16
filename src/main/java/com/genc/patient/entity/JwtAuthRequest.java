package com.genc.patient.entity;

import java.io.Serializable;

public class JwtAuthRequest implements Serializable{
	
	private String memberID;
	private String password;
	
	public JwtAuthRequest() {
		
	}
	
	
	public JwtAuthRequest(String memberID, String password) {
	
		this.memberID = memberID;
		this.password = password;
	}
	
	

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
