package com.spring.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {
	
	@GetMapping("/check")
	public ResponseEntity<?> welcome(){
		return new ResponseEntity<>("WELCOME ",HttpStatus.OK);
	}

}
