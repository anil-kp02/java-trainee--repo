package com.spring.role.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.role.dao.EmployeeDao;
import com.spring.role.entity.Employee;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee employee = employeeDao.findByEmail(email);
		
		return new org.springframework.security.core.userdetails.
				User(employee.getName(), employee.getPassword(),
						employee.getRoles().stream().map(r-> 
							new SimpleGrantedAuthority(r.getName().name()))
						.collect(Collectors.toSet()));
						
	}

}
