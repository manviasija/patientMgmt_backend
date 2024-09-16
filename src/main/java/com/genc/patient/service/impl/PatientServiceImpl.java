package com.genc.patient.service.impl; 

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genc.patient.dto.PatientDTO;
import com.genc.patient.entity.Patient;
import com.genc.patient.repository.PatientRepo;
import com.genc.patient.service.PatientService;
import com.genc.patient.exceptions.*;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepo repo;
	
	@Override
	public PatientDTO createPatient(PatientDTO DTO) {
		Patient p = this.dtotoPatient(DTO);
		Patient savedP = this.repo.save(p);
		return this.Patienttodto(savedP);
	}
	@Override
	public PatientDTO updatePatient(PatientDTO dto, Integer id) {
		// TODO Auto-generated method stub
		Patient p=this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
	
		p.setMemberID(dto.getMemberID());
		p.setName(dto.getName());
		p.setPassword(dto.getPassword());
		p.setRole(dto.getRole());
		p.setCardNo(dto.getCardNo());
		p.setGender(dto.getGender());
		p.setAddress(dto.getAddress());
		p.setDateOfRegistration(dto.getDateOfRegistration());
		p.setInsuranceNo(dto.getInsuranceNo());
		p.setMedicalHistory(dto.getMedicalHistory());
		
		Patient updatedPatient=this.repo.save(p);
		PatientDTO dto1=this.Patienttodto(updatedPatient);
		return dto1;
	}

	@Override
	public PatientDTO getPatientById(Integer id) {
		// TODO Auto-generated method stub
		Patient p=this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
		return this.Patienttodto(p);
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		// TODO Auto-generated method stub
		List<Patient> patients=this.repo.findAll();
		List <PatientDTO> dtos=patients.stream().map(patient->this.Patienttodto(patient)).collect(Collectors.toList());
				return dtos;
	}
	private Patient dtotoPatient(PatientDTO DTO) {
		Patient pat=new Patient();
		pat.setId(DTO.getId());
		pat.setMemberID(DTO.getMemberID());
		pat.setName(DTO.getName());
		pat.setPassword(DTO.getPassword());
		pat.setRole(DTO.getRole());
		pat.setCardNo(DTO.getCardNo());
		pat.setGender(DTO.getGender());
		pat.setAddress(DTO.getAddress());
		pat.setDateOfRegistration(DTO.getDateOfRegistration());
		pat.setInsuranceNo(DTO.getInsuranceNo());
		pat.setMedicalHistory(DTO.getMedicalHistory());
		
		return pat;
		 
		
	}
	private PatientDTO Patienttodto(Patient patient) {
		PatientDTO patDTO=new PatientDTO();
		patDTO.setId(patient.getId());
		patDTO.setMemberID(patient.getMemberID());

		patDTO.setName(patient.getName());
		
		patDTO.setPassword(patient.getPassword());
		patDTO.setRole(patient.getRole());
		
		patDTO.setCardNo(patient.getCardNo());
		
		patDTO.setGender(patient.getGender());
		
		patDTO.setAddress(patient.getAddress());
		
		patDTO.setDateOfRegistration(patient.getDateOfRegistration());
		
		patDTO.setInsuranceNo(patient.getInsuranceNo());
		
		patDTO.setMedicalHistory(patient.getMedicalHistory());
		
		return patDTO;
		 
		
	}
}
