package com.hibenateDemo3.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.hibenateDemo3.dao.EmployeeDao;
import com.hibenateDemo3.dto.EmployeeDto;

public class EmployeeServices {
	EmployeeDao employeeDao = new EmployeeDao();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	

	public void insertDetails() {
		EmployeeDto employee = new EmployeeDto();
		try {
			System.out.println(" Enter Nmae :");
			employee.setName(reader.readLine());
			System.out.println(" Enter email :");
			employee.setEmail(reader.readLine());
			System.out.println(" Enter Nmae of the compny :");
			employee.setCompany(reader.readLine());
			employeeDao.saveEmployee(employee);
			System.out.println(" inserted ");
			
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	//to get All Employee
	public void getAllEmployee() {
		List<EmployeeDto> list= employeeDao.getAllEmployee();
		if(list != null && !list.isEmpty()) {
			list.stream().forEach(System.out::println);
		}
		else {
			System.out.println("No Employess");
		}
	}
	//getEmployee by Id 
	public void getEmployeeById() {
		System.out.println(" Enter the id of the Employee :");
		try{
			EmployeeDto employeeDto= employeeDao.getEmployeeById(Integer.parseInt(reader.readLine()));
			if(employeeDto != null) {
				System.out.println(employeeDto);
			}else {
				System.out.println(" No employee in this id !!!");
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public void deleteEmployee() {
		System.out.println(" Enter the id of the Employee :");
		try{
			Integer id=Integer.parseInt(reader.readLine());
			EmployeeDto employeeDto= employeeDao.getEmployeeById(id);
			if(employeeDto != null) {
				employeeDao.deleteEmployee(id);
				System.out.println(" Deleted sucessfullY");
			}else {
				System.out.println(" No employee in this id !!!");
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}
	

}
