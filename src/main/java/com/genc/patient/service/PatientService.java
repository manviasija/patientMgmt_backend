package com.genc.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.genc.patient.dto.PatientDTO;
import com.genc.patient.entity.Patient;

public interface PatientService {

	PatientDTO updatePatient(PatientDTO patient,Integer id);
	
	PatientDTO getPatientById(Integer id);
	
	List<PatientDTO> getAllPatients();

	PatientDTO createPatient(PatientDTO DTO);
}
