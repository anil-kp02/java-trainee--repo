package com.criteriaAndHql;

import java.util.Scanner;

import com.criteriaAndHql.controller.CriteriaController;
import com.criteriaAndHql.controller.HQLController;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanner = new Scanner(System.in);
	

	
	//Main controller 
	public static void mainController() {
		do {
			System.out.println(" Main Menu\n"
					+ "press 1 : To Criteria sub Menu\n"
					+ "press 2 : To Hql sub Menu\n"
					+ "press 3 : To exit \n"
					+ "Enter Your Choice >>  ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: CriteriaController.criteriaController();
				
				break;
			case 2: HQLController.hqlController();
				break;
			case 3: System.out.println(" Thank You ");
			 		scanner.close();
			 		System.exit(0);

			default:System.out.println(" Enter valid Input !!");
				break;
			}
			
		}while(true);
	}
	
    public static void main( String[] args )
    {
        System.out.println(" ---------------------------------------------------");
        mainController();
    }
}
