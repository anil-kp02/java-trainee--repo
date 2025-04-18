package com.spring.role.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.role.service.CustomEmployeeDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomEmployeeDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("Authorization");
		
		String token = null;
        String username = null;
        
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
        	
        	token=authorizationHeader.substring(7);
        	username = jwtUtil.extractUserName(token);
        }
        
        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
        	UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        	
        	if(jwtUtil.validateToken(token, userDetails)) {
        		
        		UsernamePasswordAuthenticationToken authenticationToken =
        				new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        	}
        	
        }
        filterChain.doFilter(request, response);
		
	}

}
