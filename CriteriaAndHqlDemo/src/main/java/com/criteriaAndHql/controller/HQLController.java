package com.criteriaAndHql.controller;

import java.util.Scanner;

import com.criteriaAndHql.App;
import com.criteriaAndHql.service.impl.CompanyServiceImpl;
import com.criteriaAndHql.service.impl.EmployeeServiceImpl;

public class HQLController {

	
	//controller for Employee
	public static void hqlController() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println(" HQL Operation  Menu \n"
					+ "press :1 (Retrieve all employees)\n"
					+ "press :2 (Retrieve only designations from the Employee table (SQL queries))\n"
					+ "press :3 (Retrieve employee details including company name)\n"
					+ "press :4 (Retrieve employee details for a specific company ID)\n"
					+ "press :5 (Retrieve employee details where salary is greater than or equal to a"
					+ "                                           value and filtered by company ID)\n"
					+ "press :6 (Same as above but using positional parameters (?1, ?2) instead of named parameters)\n"
					+ "press :7 ( Retrieve company names where the company name matches a given value)\n"
					+ "press :8 (Retrieve company names using a join condition with JOIN e.company)\n"
					+ "press :9 (Retrieve employee names from a specific company)\n"
					+ "press :10 (Retrieve company names with employee count using LEFT JOIN and GROUP BY)\n"
					+ "press :11 (Retrieve employee names, company names, and salaries ordered by salary descending)\n"
					+ "press :12 (Retrieve employee names where company ID is in a given list)\n"
					+ "press :13 (Retrieve employee names using JOIN and filtering by multiple company IDs)\n"
					+ "press :14 To exit from Criteria Opertaion\n"
					+ "   Enter Your Choice ->>>>   ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: new EmployeeServiceImpl().getEmployessByHql();
				break;
				
			case 2: new EmployeeServiceImpl().getAllDegignations();
				break;
				
			case 3: new EmployeeServiceImpl().getEmployeDeatilsWithName();;
				break;
				
			case 4: new EmployeeServiceImpl().getEmployeByCompanyId();
				break;
				
			case 5:new EmployeeServiceImpl().getEmployeByASalaryAndCompanyId();
				break;
				
			case 6: new EmployeeServiceImpl().getEmployeByASalaryAndCompanyIdUsingPositionalParameter();
				break;
				
			case 7: new CompanyServiceImpl().getCompanyByName();
				break;
				
			case 8: new CompanyServiceImpl().getCompanyUsingJoin();
				break;
				
			case 9: new CompanyServiceImpl().getEmployeByCompanyName();
				break;
				
			case 10: new CompanyServiceImpl().getCompanyNamesWithEmployeeCount();
				break;
				
			case 11: new EmployeeServiceImpl().getEmployeeNamesCompanynameSalaryOrderByDesc();
				break;
				
			case 12: new EmployeeServiceImpl().getEmployeeNameForMultipleIds();
				break;
				
			case 13: new EmployeeServiceImpl().getEmployeeNameForMultipleIdsUsingJoin();
				break;
		
			case 14:scanner.close();
				System.out.println(" Out Of Criteria \n");
				App.mainController();
				
				break;

			default:System.out.println(" In valid choice !!!");
				break;
			}
			
		}while(true);
		
	}
	}

