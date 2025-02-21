package com.hibenateDemo3.dao;

import java.util.List;

import java.util.stream.Collectors;

import org.hibernate.Session;


import com.hibenateDemo3.dto.EmployeeDto;
import com.hibenateDemo3.entity.Company;
import com.hibenateDemo3.entity.Employee;
import com.hibenateDemo3.resources.ConnectionProvider;

public class EmployeeDao {
	
	//static SessionFactory factory;
	
	public void saveEmployee(EmployeeDto employeeDto) {
		/*factory=ConnectionProvider.getFactory();
		Session session= factory.openSession*/
		Session session = ConnectionProvider.getFactory().openSession();
		Company company ;
		
		
		session.beginTransaction();
		company=(new CompanyDao().saveOrUpdate(employeeDto.getCompany()));
		Employee employee = new Employee(employeeDto.getEmail(),employeeDto.getName(),company,null);
		session.merge(employee);
		session.getTransaction().commit();
		session.close();
		
	}
	public List<EmployeeDto> getAllEmployee(){
		Session session = ConnectionProvider.getFactory().openSession();
		List<Employee> list = session.createQuery("from Employee",Employee.class).list();
		session.close();
		List<EmployeeDto> resultList = list.stream().map(employee->EmployeeDto.entityToDto(employee)).collect(Collectors.toList());
		return resultList;
		
	}
	
	public EmployeeDto getEmployeeById(Integer id) {
		Session session = ConnectionProvider.getFactory().openSession();
		Employee employee =(Employee) session.get(Employee.class,id);
		session.close();
		EmployeeDto employeeDto = EmployeeDto.entityToDto(employee);
		return employeeDto;
	}
	
	public Integer deleteEmployee(Integer id) {
		Session session = ConnectionProvider.getFactory().openSession();
		Employee employee =(Employee) session.get(Employee.class,id);
		if(employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
			return 1;
		}
		session.close();
		return 0;
	}
	
 

}
