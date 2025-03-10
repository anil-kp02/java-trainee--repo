package com.spring.jpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpaDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Employee findByName(String name);

	Boolean existsByName(String name);

}
