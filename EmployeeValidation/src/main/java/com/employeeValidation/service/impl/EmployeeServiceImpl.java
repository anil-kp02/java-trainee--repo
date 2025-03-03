package com.employeeValidation.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import com.employeeValidation.dao.CompanyDao;
import com.employeeValidation.dao.EmployeeDao;
import com.employeeValidation.dao.impl.CompanyDaoImpl;
import com.employeeValidation.dao.impl.EmployeeDaoImpl;
import com.employeeValidation.dto.CompanyDto;
import com.employeeValidation.dto.EmployeeDto;
import com.employeeValidation.entity.Company;
import com.employeeValidation.entity.Employee;
import com.employeeValidation.service.EmployeeService;
import com.employeeValidation.validate.ValidateEmployee;

public class EmployeeServiceImpl implements EmployeeService {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	CompanyDao companyDao = new CompanyDaoImpl();

	public void addEmployee() {
		
		ValidateEmployee validation = new ValidateEmployee();
		
		try {
			// validate Employee name 
			System.out.println(" Enter The new Employe name : ");
			String name = reader.readLine();
			while(!validation.validateName(name)) {
				System.out.println(" Name Mustn contain Only Alphabate and dot \n"
						+ "Enter Name Again :");
				name=reader.readLine();
			}
			
			//validate Employee Email
			System.out.println(" Enter Mail id : ");
			String email= reader.readLine();
			while(!validation.validateEmail(email)) {
				System.out.println(" Enter valid Email :");
				email= reader.readLine();
			}
			
			//validate Phone Number 
			System.out.println(" Enter Phone Number :");
			String phoneNo=reader.readLine();
			String contactNo=validation.validatePhoneNo(phoneNo);
			while(contactNo == null) {
				System.out.println(" Enter a valid phone Number ");
				phoneNo=reader.readLine();
				contactNo=validation.validatePhoneNo(phoneNo);
			}
			
			//validate salary
			System.out.println(" Enter salary :");
			Double salary =Double.parseDouble(reader.readLine());
			while(salary<=0) {
				System.out.println(" Enter salary greater than 0");
				salary = Double.parseDouble(reader.readLine());
			}
			
			// validate Company Id 
			System.out.println(" Enter the company Id :");
			Long id = Long.parseLong(reader.readLine());
			Company company = companyDao.getCompany(id);
			CompanyDto companyDto= CompanyDto.entityToDto(company);
			while(companyDto==null) {
				System.out.println(" Enter valid company Id : ");
				id=Long.parseLong(reader.readLine());
				companyDto= CompanyDto.entityToDto(companyDao.getCompany(id));
			}
			
			EmployeeDto employeeDto = new EmployeeDto(name, email, contactNo, salary, null);
			Employee employee = EmployeeDto.dtoToEntity(employeeDto);
			employee.setCompany(company);
			
			employeeDao.addEmployee(employee);
			
			System.out.println(" Added SucessFully ");
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getEmployee() {
		
		try {
			System.out.println("Enter Employee Id : ");
			Long id = Long.parseLong(reader.readLine());
			Employee employee = employeeDao.getEmployee(id);
			EmployeeDto employeeDto = EmployeeDto.entityToDto(employee);
			if(employeeDto==null) {
				System.out.println(" No Employee In this id ");
			}else {
				System.out.println(employeeDto);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			}
		
		
	}

	public void getAllEmployee() {
		try {
			List<Employee> employees = employeeDao.getAllEmployee();
			List<EmployeeDto> employeeDtos = employees.stream().map(EmployeeDto::entityToDto).collect(
					Collectors.toList());
			if ( employeeDtos.isEmpty()) {
				System.out.println(" No Employee is there ");
			}
			else {
				employeeDtos.stream().forEach(System.out::println);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void updateEmployee() {
		try {
			System.out.println(" Enter the Employee Id :");
			Long id = Long.parseLong(reader.readLine());
			
			Employee employee = employeeDao.getEmployee(id);
			EmployeeDto employeeDto = EmployeeDto.entityToDto(employee);
			
			if(employeeDto==null) {
				System.out.println(" No Employee In this Id ");
			}else {
				if(employeeDto.getSalary() > 0d) {
					
					System.out.println(" Enter the Updated Salary Amount");
					Double updatedSalary=Double.parseDouble(reader.readLine());
					while(!(updatedSalary>0d)) {
						System.out.println(" Enter a valid Amout (Amount Must Greater than Zero) :");
						updatedSalary=Double.parseDouble(reader.readLine());
					}
					employeeDao.updateEmployeeSalary(id, updatedSalary);
					System.out.println(" Updated sucessFully ");
					
				}else {
					System.out.println(" This Employee have No salary ");
				}
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
