package com.genc.patient.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.genc.patient.exceptions.ResourceNotFoundException;

import com.genc.patient.entity.Patient;
import com.genc.patient.repository.PatientRepo;

@Service
public class JwtUserDetailService implements UserDetailsService  {
	
	
	@Autowired
	private PatientRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String memberID) throws UsernameNotFoundException {
		
		
	
		
		// load user from database in repository
		Patient user=repo.findByMemberID(memberID);
		
		
		
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found with user ID:" + memberID);
		}
		
		//if(user==null) throw new ResourceNotFoundException("user not found alreday  exist");
		
		
		List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(user.getRole());
		authorities.add(authority);
		return new org.springframework.security.core.userdetails.User(user.getMemberID(), user.getPassword(), authorities);

	}


	
	
	

}
