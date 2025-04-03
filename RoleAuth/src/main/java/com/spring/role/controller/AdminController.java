package com.spring.role.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.role.entity.Employee;
import com.spring.role.entity.Role;
import com.spring.role.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/assign-role")
	public ResponseEntity<?> assignRole(@RequestParam String email ,@RequestParam Set<Role> roles){
		Employee employee = employeeService.getEmployeeByEmail(email);
		employee.setRoles(roles);
		employeeService.saveEmployee(employee);
		
		return new ResponseEntity<>("Role Assigned successfully",HttpStatus.OK);
	}

}
