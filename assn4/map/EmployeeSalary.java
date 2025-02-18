package com.assn4.map;

import java.util.HashMap;
import java.util.Map;

public class EmployeeSalary {
	public static void calculateMaxSalary(Map<String, Double> employee) {
		Double maxSalary=Double.MIN_VALUE;
		for(Map.Entry<String, Double>entry:employee.entrySet()) {
			if(entry.getValue()>maxSalary) {
				maxSalary=entry.getValue();
			}
		}
		for(Map.Entry<String, Double>entry:employee.entrySet()) {
			if(maxSalary==entry.getValue()) {
				System.out.println("Employee NAme :"+entry.getKey()+ "    Salary :"+entry.getValue());
			}
		}
	}
public static void main(String[] args) {
	Map<String, Double> employee=new HashMap<>();
	employee.put("Anil",25000.0 );
	employee.put("Abhi",35000.0 );
	employee.put("Subham",21999.0 );
	employee.put("Mano",45000.0 );
	employee.put("Aman",1200.0 );
	employee.put("Satya",36999.0 );
	
	calculateMaxSalary(employee);
}
}
