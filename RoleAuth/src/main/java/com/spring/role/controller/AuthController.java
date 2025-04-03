package com.spring.role.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.role.security.JwtUtil;
import com.spring.role.service.EmployeeService;

@Controller
@RequestMapping("auth")
public class AuthController {

	private AuthenticationManager authenticationManager;
	private JwtUtil jwtUtil;
	private EmployeeService employeeService;

	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
			EmployeeService employeeService) {
		
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.employeeService = employeeService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestParam String username, @RequestParam String password){
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		String token = jwtUtil.generateToken(username);
		
		return new ResponseEntity<>(token,HttpStatus.OK);
	}
	


}
