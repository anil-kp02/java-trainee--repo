package com.spring.jpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpaDemo.dto.EmployeeDto;
import com.spring.jpaDemo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// @Autowired
	// private AddressService addressService;

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {

		if (employeeDto.getId() == null) {

			if (employeeService.existsByName(employeeDto.getName())) {
				return new ResponseEntity<>("Alreay Employee Exists in this name ", HttpStatus.BAD_REQUEST);
			} else {
				EmployeeDto dto = employeeService.addEmployee(employeeDto);
				if (dto != null) {
					return new ResponseEntity<>(dto, HttpStatus.OK);
				}
				return new ResponseEntity<>("Cant be added", HttpStatus.BAD_REQUEST);
			}

		}

		else {

			EmployeeDto dto = employeeService.updateEmployee(employeeDto);
			if (dto != null) {
				return new ResponseEntity<>(dto, HttpStatus.OK);
			}
			return new ResponseEntity<>("Update cant performed", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/find/all")
	public ResponseEntity<?> getAllEmployee() {
		List<EmployeeDto> dtos = employeeService.getAllEmployee();
		if (!dtos.isEmpty()) {
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("NO Employee Are there ", HttpStatus.BAD_REQUEST);
		}

	}

}
