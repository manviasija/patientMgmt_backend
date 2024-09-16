package com.genc.patient.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PatientDTO {
	
	private String role;
	private String memberID;

	public Integer id;

	private String name;
	
	private String password;
	private String CardNo;
	private String Gender;
	private String Address;
	private Date dateOfRegistration;
	private String InsuranceNo;

	private String MedicalHistory;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardNo() {
		return CardNo;
	}

	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getInsuranceNo() {
		return InsuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.InsuranceNo = insuranceNo;
	}

	public String getMedicalHistory() {
		return MedicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.MedicalHistory = medicalHistory;
	}
	
	
	}
