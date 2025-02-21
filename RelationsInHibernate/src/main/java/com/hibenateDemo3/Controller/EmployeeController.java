package com.hibenateDemo3.Controller;

import java.util.Scanner;

import com.hibenateDemo3.services.EmployeeServices;

public class EmployeeController {
	EmployeeServices employeeServices = new EmployeeServices();
	 
	public void Menu()	{
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
	
	do {
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++\n"
				+ "              Employee MENU             \n"
				+ "  ----------------------------------------------\n"
				+ "		1: To add Employe\n"
				+ "		2: To Get employe By Id\n"
				+ " 	3: To get All Employee\n"
				+ "		4: To delete Employee\n"
				+ "		5: To Exit");
		
		System.out.println(" Enter The choice : ");
		switch (scanner.nextInt()) {
		case 1: employeeServices.insertDetails();
			
			break;
		case 2: employeeServices.getEmployeeById();
			break;
		case 3: employeeServices.getAllEmployee();
			break;
		case 4: employeeServices.deleteEmployee();
			break;
		case 5:
			System.out.println(" Out of Employee Menu ");
			scanner.close();
			flag= false;

		default: System.out.println(" Enter valid choice !!");
			break;
		}
		
	}while(flag);
	
}

}
