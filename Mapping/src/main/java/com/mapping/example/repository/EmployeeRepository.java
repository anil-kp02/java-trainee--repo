package com.mapping.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.mapping.example.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	List<Employee> findAllByNameAsc();

	@NativeQuery("select * from employee order by name asc")
	List<Employee> findAllOrderByNameAsc();

	Employee findByName(String name);

	//@NativeQuery("select * from employee where name like (%?1%)")
	List<Employee> findByNameNotLike(String name);

	List<Employee> findDistinctByName(String name);

	List<Employee> findByNameAndSalary(String name, Double salary);

	List<Employee> findByNameOrSalary(String name, Double salary);

	List<Employee> findBySalaryLessThan(Double salary);

	@NativeQuery("select name from employee order by salary desc")
	List<String> findByNameOrderBySalaryDesc();

	List<Employee> findBySalaryBetween(Double lowerLimit, Double upperLimit);

	List<Employee> findBySalaryLessThanEqual(Double salary);

	List<Employee> findBySalaryNull();

	List<Employee> findByNameLike(String name);
	//StartingWith , EndingWith , Containing (in these the inner syntax is 'like' but % Appear in different location
	

	List<Employee> findByNameNot(String name);

	List<Employee> findByAgeIn(List<Integer> list);

	List<Employee> findByNameIgnoreCase(String name);
	
	

}
