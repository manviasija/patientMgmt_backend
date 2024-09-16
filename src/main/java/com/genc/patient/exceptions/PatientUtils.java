package com.genc.patient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PatientUtils {
	
	public PatientUtils() {
		
	}
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}",httpStatus);
	}
}
