package com.criteriaAndHql.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.criteriaAndHql.dao.EmployeeDao;
import com.criteriaAndHql.dao.DaoImpl.EmployeeDaoImpl;
import com.criteriaAndHql.dto.EmployeeDto;
import com.criteriaAndHql.entity.Employee;
import com.criteriaAndHql.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public void getEmployessByCriteria() {
		List<Employee> employees = employeeDao.getEmployessByCriteria();
		List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
		
		if(list.isEmpty()) {
			System.out.println(" Empty List");
		}else {
			for(EmployeeDto employeeDto:list) {
				System.out.println(employeeDto);
			}
		}

	}
	
	
	
	@Override
	public void getEmployeeWithSalaryGreater80K() {
		List<Employee> employees = employeeDao.getEmployeeWithSalaryGreater80K();
		List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
		
		if(list.isEmpty()) {
			System.out.println(" Empty List");
		}else {
			for(EmployeeDto employeeDto:list) {
				System.out.println(employeeDto);
			}
		}
		
	}

	@Override
	public void getEmployeeBasedOnSalaryAndCompanyId() {

		try {
			System.out.println(" Enter the salary : ");
			Double salary = Double.parseDouble(reader.readLine());
			System.out.println(" Enter the Company ID :");
			Long id = Long.parseLong(reader.readLine());
			
			List<Employee> employees = employeeDao.getEmployeeBasedOnSalaryAndCompanyId(salary, id);
			List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
			
			if(list.isEmpty()) {
				System.out.println(" Empty List");
			}else {
				for(EmployeeDto employeeDto:list) {
					System.out.println(employeeDto);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getEmployeeOrderBySalaryDesc() {
		List<Employee> employees = employeeDao.getEmployeeOrderBySalaryDesc();
		List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
		
		if(list.isEmpty()) {
			System.out.println(" Empty List");
		}else {
			for(EmployeeDto employeeDto:list) {
				System.out.println(employeeDto);
			}
		}
		
	}

	@Override
	public void getEmployeeNameAndSalary() {
		List<Object[]> list=employeeDao.getEmployeeNameAndSalary();
		if(list.isEmpty()) {
			System.out.println(" No data Found");
		}else {
			for(Object[] objects:list) {
				System.out.println(" Name :"+objects[0] +" Salary :"+objects[1]);
			}
		}
	}

	@Override
	public void getEmployeeNamesByCompanyIds() {
		try {
			System.out.println(" Enter the how many company id you want to add  :");
			Integer size = Integer.parseInt(reader.readLine());
			
			List<Long> ids = new ArrayList<>();
			for(int i=0;i<size;i++) {
				System.out.println(" Enter the Company ID :");
				Long id = Long.parseLong(reader.readLine());
				ids.add(id);
			}
			
			
			List<String> list = employeeDao.getEmployeeNamesByCompanyIds(ids);
			
			if(list.isEmpty()) {
				System.out.println(" No employee found in these  id ");
			}
			else {
				for(String name : list) {
					System.out.println(name);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getEmployessByHql() {
		List<Employee> employees = employeeDao.getEmployessByHql();
		List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
		
		if(list.isEmpty()) {
			System.out.println(" Empty List");
		}else {
			for(EmployeeDto employeeDto:list) {
				System.out.println(employeeDto);
			}
		}
		
	}

	@Override
	public void getAllDegignations() {
		
		List<String> list = employeeDao.getAllDegignations();
		if(list.isEmpty()) {
			System.out.println(" Empty degignation List");
		}else {
			for(String name:list) {
				System.out.println(name);
			}
		}
		
	}

	@Override
	public void getEmployeDeatilsWithName() {
		List<Object[]> list = employeeDao.getEmployeDeatilsWithName();
		if(list.isEmpty()) {
			System.out.println(" no data found ");
		}else {
			for(Object[] objects:list) {
				System.out.println(objects[0] + " "+ objects[1] +" "+ objects[2] + " "+objects[3]);
			}
		}
		
	}

	@Override
	public void getEmployeByCompanyId() {
		try {
			
			System.out.println(" Enter the Company ID :");
			Long id = Long.parseLong(reader.readLine());
			
			List<Employee> employees = employeeDao.getEmployeByCompanyId(id);
			List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
			
			if(list.isEmpty()) {
				System.out.println(" Empty List");
			}else {
				for(EmployeeDto employeeDto:list) {
					System.out.println(employeeDto);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getEmployeByASalaryAndCompanyId() {
		try {
			System.out.println(" Enter the salary : ");
			Double salary = Double.parseDouble(reader.readLine());
			System.out.println(" Enter the Company ID :");
			Long id = Long.parseLong(reader.readLine());
			
			List<Employee> employees = employeeDao.getEmployeByASalaryAndCompanyId(salary, id);
			List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
			
			if(list.isEmpty()) {
				System.out.println(" Empty List");
			}else {
				for(EmployeeDto employeeDto:list) {
					System.out.println(employeeDto);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getEmployeByASalaryAndCompanyIdUsingPositionalParameter() {
		try {
			System.out.println(" Enter the salary : ");
			Double salary = Double.parseDouble(reader.readLine());
			System.out.println(" Enter the Company ID :");
			Long id = Long.parseLong(reader.readLine());
			
			List<Employee> employees = employeeDao.getEmployeByASalaryAndCompanyIdUsingPositionalParameter(salary, id);
			List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
			
			if(list.isEmpty()) {
				System.out.println(" Empty List");
			}else {
				for(EmployeeDto employeeDto:list) {
					System.out.println(employeeDto);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getEmployeeNamesCompanynameSalaryOrderByDesc() {
		List<Object[]> list = employeeDao.getEmployeeNamesCompanynameSalaryOrderByDesc();
		if(list.isEmpty()) {
			System.out.println(" no data found ");
		}else {
			for(Object[] objects:list) {
				System.out.println(objects[0] + " "+ objects[1] +" "+ objects[2] );
			}
		}
		
	}

	@Override
	public void getEmployeeNameForMultipleIds() {
		try {
			System.out.println(" Enter the how many company id you want to add  :");
			Integer size = Integer.parseInt(reader.readLine());
			
			List<Long> ids = new ArrayList();
			for(int i=0;i<size;i++) {
				System.out.println(" Enter the Company ID :");
				Long id = Long.parseLong(reader.readLine());
				ids.add(id);
			}
			
			
			List<String> list = employeeDao.getEmployeeNameForMultipleIds(ids);
			
			if(list.isEmpty()) {
				System.out.println(" No employee found in these  id ");
			}
			else {
				for(String name : list) {
					System.out.println(name);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getEmployeeNameForMultipleIdsUsingJoin() {
		try {
			System.out.println(" Enter the how many company id you want to add  :");
			Integer size = Integer.parseInt(reader.readLine());
			
			List<Long> ids = new ArrayList();
			for(int i=0;i<size;i++) {
				System.out.println(" Enter the Company ID :");
				Long id = Long.parseLong(reader.readLine());
				ids.add(id);
			}
			
			
			List<String> list = employeeDao.getEmployeeNameForMultipleIdsUsingJoin(ids);
			
			if(list.isEmpty()) {
				System.out.println(" No employee found in these  id ");
			}
			else {
				for(String name : list) {
					System.out.println(name);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
