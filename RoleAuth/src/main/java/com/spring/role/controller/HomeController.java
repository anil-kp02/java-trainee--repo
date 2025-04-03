package com.spring.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.role.entity.Employee;
import com.spring.role.service.EmployeeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee){
		employee.setPassword(
				new BCryptPasswordEncoder().encode(employee.getPassword()));
		
		employeeService.saveEmployee(employee);
		
		return new ResponseEntity<>("Wel come",HttpStatus.OK);
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll(){
		List<Employee> employees = employeeService.findAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

}
