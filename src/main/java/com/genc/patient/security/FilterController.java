package com.genc.patient.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.genc.patient.service.JwtUserDetailService;

import io.jsonwebtoken.Claims;

@Component
public class FilterController extends OncePerRequestFilter {
	
	@Autowired
	private JwtUserDetailService jwtUserDetailService;
	
	@Autowired
	private  JwtTokenHelper jwtTokenHelper;
	
	Claims claims=null;
	String memberID=null;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		
		
		
		if(request.getServletPath().matches("/authenticate/")) {
			filterChain.doFilter(request, response);
		}
		
		else {
			final String authorizationHeader=request.getHeader("Authorization");
			String jwt=null;
			
			
			if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")){
				jwt=authorizationHeader.substring(7); 
				memberID=jwtTokenHelper.extractUsername(jwt);
			
			}
			
			
			if(memberID != null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails=jwtUserDetailService.loadUserByUsername(memberID);
				
				if(jwtTokenHelper.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken memberIDPasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					memberIDPasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(memberIDPasswordAuthenticationToken);
				}
			}
			
			filterChain.doFilter(request, response);
			
			
		}// else
		
		
		
		
		
		
		
		
		
	}
	
	// get current user
			public String getCurrentUser() {
				return memberID;
			}
	
	
	

}
