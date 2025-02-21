package com.hibenateDemo3.Controller;

import java.util.Scanner;



 class App 
{
    public static void main( String[] args )
    {
		
		Scanner scanner = new  Scanner(System.in);
		do {
			System.out.println(" ++++++++++++++++++++++++++++++++++++++++++\n"
					+ "              MAIN MENU             \n"
					+ "  ----------------------------------------------\n"
					+ "		1: To Employe SubMenu\n"
					+ "		2: To Company SubMenu\n"
					+ " 	3: To Project SubMenu\n"
					+ "		4: To Exit");
			
			switch (scanner.nextInt()) {
			case 1: new EmployeeController().Menu();
				break;
			case 2: new CompanyController().menu();
				break;
			case 3: new ProjectController().menu();
				break;
			case 4: scanner.close();
				System.out.println(" Thank You !!");
				System.exit(0);
			default: System.out.println(" Enter Valid InPut ");
				break;
			}
			
		}while(true);
    	
		 
    	
    }
}
