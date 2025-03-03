package com.employeeValidation;

import java.util.Scanner;

import com.employeeValidation.service.EmployeeService;
import com.employeeValidation.service.impl.EmployeeServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        do {
        	System.out.println(" --------------------------------------\n"
        			+ " press 1 : To Add employee\n"
        			+ " press 2 : To get Employee\n"
        			+ " press 3 : To get All Employee\n"
        			+ " press 4 : To Update emplopyee\n"
        			+ " press 5 : To Exit \n"
        			+ " Enter Your choice ->>>>\n");
        	int choice = scanner.nextInt();
        	EmployeeService employeeService = new EmployeeServiceImpl();
        	
        switch (choice) {
		case 1: employeeService.addEmployee();
			
			break;
	case 2: employeeService.getEmployee();
			
			break;

	case 3: employeeService.getAllEmployee();
		
		break;

	case 4: employeeService.updateEmployee();
		
		break;
	
	case 5: scanner.close();
		System.out.println(" thank you ");
		System.exit(0);


		default: System.out.println(" Enter ab valid Input");
			break;
		}
        	
        	
        	
        }while(true);
    }
}
