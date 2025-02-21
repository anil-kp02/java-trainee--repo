package com.hibenateDemo3.Controller;

import java.util.Scanner;

import com.hibenateDemo3.services.CompanyServices;

public class CompanyController {
	CompanyServices companyServices = new CompanyServices();
	
	public void menu() {
		Scanner scanner = new  Scanner(System.in);
		boolean flag=true;
		do {
			System.out.println(" ++++++++++++++++++++++++++++++++++++++++++\n"
					+ "              Company MENU             \n"
					+ "  ----------------------------------------------\n"
					+ "		1: To add Company\n"
					+ "		2: To  get employee by Company \n"
					+ " 	3: To delete company\n"
					+ "		4: To Exit\n");
			
			System.out.println(" Enter Your choice ");
			switch (scanner.nextInt()) {
			case 1:companyServices.addCompany();
				
				break;
				
			case 2:companyServices.getEmployees();
				break;
			case 3:companyServices.deleteCompany();
				break;
			case 4: System.out.println(" You Are Out Of Company Menu ");
					scanner.close();
				flag=false;
			

			default: System.out.println(" Invalid choice !!");
				break;
			}
			
		}while(flag);
	}

}
