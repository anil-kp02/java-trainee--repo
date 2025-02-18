package com.assn6.exampleFunctionalInterface;

public class Employee implements Comparable<Employee>{
	
	int id;
	String name;
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}

	@Override
	public int compareTo(Employee emp ) {
		if(id==emp.id) {
			return 0;
		}
		else if(id>emp.id){
			return 1;
		}
		else
			return -1;
	}

}
