package com.assn6.exampleFunctionalInterface;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableDemo {
	public static void main(String[] args) {
		ArrayList<Employee> employeeDb=new ArrayList<>();
		employeeDb.add(new Employee(28,"Subham"));
		employeeDb.add(new Employee(43,"MAno"));
		employeeDb.add(new Employee(60,"Anil"));
		employeeDb.add(new Employee(59,"Satya"));
		
		Collections.sort(employeeDb);
		for(Employee emp:employeeDb) {
			System.out.println(emp.name  +"   " +emp.id);
		}
	}

}
