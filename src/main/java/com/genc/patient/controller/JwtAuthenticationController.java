package com.genc.patient.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genc.patient.security.*;
import com.genc.patient.service.JwtUserDetailService;
import com.genc.patient.entity.JwtAuthRequest;
import com.genc.patient.entity.JwtAuthResponse;


@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private JwtUserDetailService jwtUserDetailService;
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<JwtAuthResponse> createAuthenticationToken(@RequestBody JwtAuthRequest jwtAuthRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtAuthRequest.getMemberID(),jwtAuthRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			return new ResponseEntity<JwtAuthResponse>(new JwtAuthResponse("",""),HttpStatus.UNAUTHORIZED);
		}
		
		final UserDetails userDetails=jwtUserDetailService.loadUserByUsername(jwtAuthRequest.getMemberID());
		
		String jwt=jwtTokenHelper.generateToken(userDetails);
		String role=userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
		return new ResponseEntity<JwtAuthResponse>(new JwtAuthResponse(jwt,role),HttpStatus.CREATED);
	}

}
