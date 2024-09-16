package com.genc.patient.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.NoArgsConstructor;

@Entity
@Table(name="patient")

public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String role;
	
	@Column(unique=true)
	private String memberID;
	

	private String name;

	private String password;


	private String CardNo;

	private String Gender;

	
	private String Address;

	private Date dateOfRegistration;

	private String InsuranceNo;

	private String MedicalHistory;
	
	
	public Patient() {
		
	}
	


	public Patient(Integer id, String role, String memberID, String name, String password, String cardNo,
			String gender, String address, Date dateOfRegistration, String insuranceNo, String medicalHistory) {
		// super();
		this.id = id;
		this.role = role;
		this.memberID = memberID;
		this.name = name;
		this.password = password;
		this.CardNo = cardNo;
		this.Gender = gender;
		this.Address = address;
		this.dateOfRegistration = dateOfRegistration;
		this.InsuranceNo = insuranceNo;
		this.MedicalHistory = medicalHistory;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() { return id; }
	  
	public void setId(Integer id) { this.id = id; }
	  
	 
	

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
		InsuranceNo = insuranceNo;
	}

	public String getMedicalHistory() {
		return MedicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		MedicalHistory = medicalHistory;
	}
		
}
