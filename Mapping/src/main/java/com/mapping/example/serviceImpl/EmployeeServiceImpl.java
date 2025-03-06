package com.mapping.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.example.entity.Employee;
import com.mapping.example.repository.EmployeeRepository;
import com.mapping.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployeeList() {
		List<Employee> emplList = employeeRepository.findAllOrderByNameAsc();
		return emplList;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee != null && employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		Employee employee = employeeRepository.findByName(name);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeeByNameNotLike(String name) {
		List<Employee> empList=employeeRepository.findByNameNotLike(name);
 		return empList;
	}

	@Override
	public List<Employee> findDistinctByName(String name) {
		List<Employee> empList= employeeRepository.findDistinctByName(name);
		return empList;
	}

	@Override
	public List<Employee> findByNameAndSalary(String name, Double salary) {
		List<Employee> empList= employeeRepository.findByNameAndSalary(name,salary);
		return empList;
	}

	@Override
	public List<Employee> findByNameOrSalary(String name, Double salary) {
		List<Employee> empList= employeeRepository.findByNameOrSalary(name,salary);
		return empList;
	}

	@Override
	public List<Employee> findBySalaryLessThan(Double salary) {
		List<Employee> empList= employeeRepository.findBySalaryLessThan(salary);
		return empList;
	}

	@Override
	public List<String> findByNameOrderBySalaryDesc() {
		List<String> empList= employeeRepository.findByNameOrderBySalaryDesc();
		return empList;
	}

	@Override
	public List<Employee> findBySalaryBetween(Double lowerLimit, Double upperLimit) {
		List<Employee> empList = employeeRepository.findBySalaryBetween(lowerLimit,upperLimit);
		return empList;
	}

	@Override
	public List<Employee> findBySalaryLessThanEqual(Double salary) {
		List<Employee> empList= employeeRepository.findBySalaryLessThanEqual(salary);
		return empList;
	}

	@Override
	public List<Employee> findBySalaryNull() {
		List<Employee> empList= employeeRepository.findBySalaryNull();
		return empList;
	}

	@Override
	public List<Employee> findByNameLike(String name) {
		List<Employee> empList= employeeRepository.findByNameLike(name);
		return empList;
	}

	@Override
	public List<Employee> findByNameNot(String name) {
		List<Employee> empList= employeeRepository.findByNameNot(name);
		return empList;
	}

	@Override
	public List<Employee> findByAgeIn(List<Integer> list) {
		List<Employee> employees = employeeRepository.findByAgeIn(list);
		return employees;
	}

	@Override
	public List<Employee> getEmployeeByNameIgnoreCase(String name) {
		List<Employee> employees = employeeRepository.findByNameIgnoreCase(name);
		return employees;
	}
	
	
	
	

}
