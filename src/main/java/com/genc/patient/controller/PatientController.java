package com.genc.patient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genc.patient.dto.PatientDTO;
import com.genc.patient.entity.Patient;
import com.genc.patient.repository.PatientRepo;
import com.genc.patient.service.PatientService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO DTO) {
		PatientDTO updatedDTO = this.service.createPatient(DTO);
		return new ResponseEntity<>(updatedDTO, HttpStatus.CREATED);
	}
	//put-update user
	@PutMapping("/patients/{id}")
	public ResponseEntity<PatientDTO> updatePatient(@Valid @RequestBody PatientDTO dto, @PathVariable("id") Integer uid) {
		PatientDTO updatedPatient = this.service.updatePatient(dto, uid);
		return ResponseEntity.ok(updatedPatient);
	}
	// GET - user get
		@GetMapping("/patients")
		public ResponseEntity<List<PatientDTO>> getAllPatients() {
			return ResponseEntity.ok(this.service.getAllPatients());
		}

		// GET - user get
		@GetMapping("/patients/{id}")
		public ResponseEntity<PatientDTO> getPatientById(@PathVariable Integer id) {
			return ResponseEntity.ok(this.service.getPatientById(id));
		}

	
}
