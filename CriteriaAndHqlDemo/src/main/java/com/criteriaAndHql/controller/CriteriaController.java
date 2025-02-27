package com.criteriaAndHql.controller;

import java.util.Scanner;

import com.criteriaAndHql.App;
import com.criteriaAndHql.service.impl.CompanyServiceImpl;
import com.criteriaAndHql.service.impl.EmployeeServiceImpl;

public class CriteriaController {
	// controller for company
	public static void criteriaController() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println(" Criteria Operation  Menu \n"
					+ "press :1 (retrieve All employee)\n"
					+ "press :2 (Filter employees with salary greater than 80,000 and\n"
					+ "                order by salary descending )\n"
					+ "press :3 (Filter employees based on salary and company ID using Restrictions.or())\n"
					+ "press :4 (Retrieve employees ordered by salary descending)\n"
					+ "press :5 (Retrieve specific columns (employee name and salary) using projections)\n"
					+ "press :6 (Retrieve only company names based on company ID using projection)\n"
					+ "press :7 (Fetch employee names from multiple companies based on a list of company IDs )\n"
					+ "press :8 To exit from Criteria Opertaion\n"
					+ "   Enter Your Choice ->>>>   ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: new EmployeeServiceImpl().getEmployessByCriteria();
				
				break;
			case 2: new EmployeeServiceImpl().getEmployeeWithSalaryGreater80K();
				
				break;
			case 3: new EmployeeServiceImpl().getEmployeeBasedOnSalaryAndCompanyId();
		
				break;
			case 4: new EmployeeServiceImpl().getEmployeeOrderBySalaryDesc();
		
				break;
			case 5: new EmployeeServiceImpl().getEmployeeNameAndSalary();
		
				break;
			case 6: new CompanyServiceImpl().getCompanyNamesById();
			
				break;
			case 7: new EmployeeServiceImpl().getEmployeeNamesByCompanyIds();
			
				break;
			case 8:scanner.close();
				System.out.println(" Out Of Criteria \n");
				App.mainController();
				
				break;

			default:System.out.println(" In valid choice !!!");
				break;
			}
			
		}while(true);
		
	}
}

/*
 * / Criteria Queries retrieve All employee Retrieve all employees Filter
 * employees with salary greater than 80,000 and order by salary descending
 * Filter employees based on salary and company ID using Restrictions.or()
 * Retrieve employees ordered by salary descending Retrieve specific columns
 * (employee name and salary) using projections Retrieve only company names
 * based on company ID using projections Fetch employee names from multiple
 * companies based on a list of company IDs (Active query)
 */