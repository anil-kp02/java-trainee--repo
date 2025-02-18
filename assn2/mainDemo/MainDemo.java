package com.assn2.mainDemo;

import java.util.Scanner;

import com.assn2.inheritance.EmployeeDataBase;

public class MainDemo extends EmployeeDataBase {
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		EmployeeDataBase obj=new EmployeeDataBase();
		do{
			
			System.out.println("Enter The Company name For which You work");
			obj.getCompanyDetails(sc.nextLine());
			
		    System.out.println("Enter The Company Name For Which You want to know The Department Details :");
		    String[]departmentDetails=obj.getDepartmentDetails(sc.nextLine());
		    for(String dept:departmentDetails) {
		    	System.out.println(dept);
		    }
		
		    System.out.println("Enter The Company Name For Which You want to know The Employee Details");
		    String [] employeeName=obj.getUserByCompanyName(sc.nextLine());
		    for(String emp:employeeName) {
		    	System.out.println(emp);
		    }
		    
		    System.out.println("Enter the Employee Name Which You want To search");
		    obj.getEmployeeByName(sc.nextLine());
		    
		    System.out.println("If you want to know about the senior press 1 other wise press any number");
		    if(sc.nextInt()==1) {
		    	String[] senior=obj.getSeniorDetails();
		    	 for(String s:senior) {
				    	System.out.println(s);
				    }
		    	
		    }
		    else {
		    	System.out.println("Thank You");
		    }
		    System.out.println("Do you want Learning Details press1 otherwise press any digit");
		    if(sc.nextInt()==1) {
		    	obj.learningDetails();
		    }
		    else {
		    	System.out.println("Thank You");
		    }
		    
		    System.out.println("Enter the senior Employee name which you want to search :");
		    
		    sc.nextLine();
		    obj.getSeniorDetails(sc.nextLine());
		    
		    System.out.println("For Exit Press 0 other wise press any Number");
		    if(sc.nextInt()==0) {
		    	System.out.println("Thank you");
		    	System.exit(0);
		    }
		    else {
		    	System.out.println("Please continue");
		    }
		    
		
		
		
		
	}while(true);
	}

}
