package com.mapping.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.example.entity.Employee;
import com.mapping.example.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public ResponseEntity<?> getEmployeeList() {
		List<Employee> employeeList = employeeService.getAllEmployeeList();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/find/by/id")
	public ResponseEntity<?> findEmployeeById(@RequestParam("id") Long id) {
		Employee emp = employeeService.getEmployeeById(id);
		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee not found with the provided id.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/find/by/name")
	public ResponseEntity<?> findEmployeeByName(@RequestParam("name") String name) {
		Employee emp = employeeService.getEmployeeByName(name);
		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee not found with the provided name.", HttpStatus.BAD_REQUEST);
	}
	
	//IgnoreCase
	@GetMapping("/find/by/name/ignore/case")
	public ResponseEntity<?> findEmployeeByNameIgnoreCase(@RequestParam("name") String name) {
		List<Employee> employees = employeeService.getEmployeeByNameIgnoreCase(name);
		if (!employees.isEmpty()) {
			return new ResponseEntity<>(employees, HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee not found with the provided name.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/find/all/by/name/not/like")
	public ResponseEntity<?> findAllByNameLike(@RequestParam("name") String name) {
		List<Employee> emp = employeeService.getAllEmployeeByNameNotLike(name);
		if (!emp.isEmpty()) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee not found with the provided name.", HttpStatus.BAD_REQUEST);
	}

	// Distinct
	@GetMapping("/find/distinct/by/name")
	public ResponseEntity<?> findDistinctByName(@RequestParam("name") String name) {
		List<Employee> emp = employeeService.findDistinctByName(name);
		if (emp.isEmpty()) {
			return new ResponseEntity<>("No Distinct data found By this name ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);

	}

	// And
	@GetMapping("find/by/name/and/salary")
	public ResponseEntity<?> findByNameAndSalary(@RequestParam("name") String name,
			@RequestParam("salary") Double salary) {
		List<Employee> emp = employeeService.findByNameAndSalary(name, salary);
		if (emp.isEmpty()) {
			return new ResponseEntity<>("No Distinct data found By this name ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// or
	@GetMapping("find/by/name/or/salary")
	public ResponseEntity<?> findByNameOrSalary(@RequestParam("name") String name,
			@RequestParam("salary") Double salary) {
		List<Employee> emp = employeeService.findByNameOrSalary(name, salary);
		if (emp.isEmpty()) {
			return new ResponseEntity<>("No Distinct data found By this name ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// Less Than Similarly GreaterThan
	@GetMapping("find/by/salary/lessthan")
	public ResponseEntity<?> findBySalaryLessThan(@RequestParam("salary") Double salary) {
		List<Employee> empLists = employeeService.findBySalaryLessThan(salary);
		if (empLists.isEmpty()) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(empLists, HttpStatus.OK);

	}

	// LessThanEqual or greaterThanEqual
	@GetMapping("find/by/salary/lessthan/equal")
	public ResponseEntity<?> findBySalaryLessThanEqual(@RequestParam("salary") Double salary) {
		List<Employee> empLists = employeeService.findBySalaryLessThanEqual(salary);
		if (empLists.isEmpty()) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(empLists, HttpStatus.OK);

	}

	// OrderBy Ascending or descending
	@GetMapping("find/name/order/by/salary")
	public ResponseEntity<?> getAllEmployeeDesc() {
		List<String> employees = employeeService.findByNameOrderBySalaryDesc();

		if (employees.isEmpty()) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// Between
	@GetMapping("get/employee/salary/between")
	public ResponseEntity<?> getEmployeeSalaryBetween(@RequestParam("lowerLimit") Double lowerLimit,
			@RequestParam("upperLimit") Double upperLimit) {
		List<Employee> employees = employeeService.findBySalaryBetween(lowerLimit, upperLimit);

		if (employees.isEmpty()) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// IsNull, Null -> findBySalary(Is)Null
	@GetMapping("get/having/salary/null")
	public ResponseEntity<?> getEmployeeHavingNullSalary() {
		List<Employee> employees = employeeService.findBySalaryNull();

		if (employees.isEmpty()) {
			return new ResponseEntity<>("No data found having no Salary", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// Like -> findByNameLike similarly NotLike
	@GetMapping("get/name/like")
	public ResponseEntity<?> getEmployeeNameLike(@RequestParam("name") String name) {

		List<Employee> employees = employeeService.findByNameLike(name);

		if (employees.isEmpty()) {
			return new ResponseEntity<>("No data found having THis name ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);

	}

	// Not
	@GetMapping("get/name/not")
	public ResponseEntity<?> getEmployeeNameNot(@RequestParam("name") String name) {
		List<Employee> employees = employeeService.findByNameNot(name);

		if (employees.isEmpty()) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// IN  similarly 'Not In '
	@GetMapping("get/age/in")
	public ResponseEntity<?> getEmployeesAgeIn(@RequestParam("list") List<Integer> list) {
		List<Employee> employees = employeeService.findByAgeIn(list);

		if (employees.isEmpty()) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

}
