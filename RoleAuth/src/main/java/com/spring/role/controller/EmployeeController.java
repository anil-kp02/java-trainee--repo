package com.spring.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.role.service.DataExportService;
import com.spring.role.service.EmailService;


@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmailService emailService;
	@Autowired
	private DataExportService dataExportService;
	
	@PostMapping("/greet")
	public ResponseEntity<?> greetViaEmail(@RequestParam String email,@RequestParam String msg){
		
		emailService.sendGreet(email, msg);
		
		return new ResponseEntity<>("Send sucessfully",HttpStatus.OK);
	}
	
	@GetMapping("/download-xss")
	public ResponseEntity<?> exportViaXss(){
		
		byte[] excelFile= dataExportService.generateExcel();
		
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		 * headers.setContentDispositionFormData("attachment","employess.xlsx");
		 */
		
		return new ResponseEntity<>(excelFile,/*headers,*/HttpStatus.OK);
		
	}
}
