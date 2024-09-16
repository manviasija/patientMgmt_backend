package com.genc.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;  

import com.genc.patient.entity.Patient;


public interface PatientRepo extends JpaRepository<Patient,Integer>{
	Patient  findByMemberID(String memberID);
}
 