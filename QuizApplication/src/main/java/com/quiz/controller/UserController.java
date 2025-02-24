package com.quiz.controller;

import java.util.Scanner;

import com.quiz.service.UserService;

/**
 * Hello world!
 *
 */
public class UserController 
{
    public static void main( String[] args )
    {
		
	Scanner scanner = new Scanner(System.in);
	do {
		
		System.out.println("   ++++++++++++++++++++++++++++\n"
				+ "       Menu            \n"
				+ "--------------------------------\n"
				+ "press 1: To add User \n"
				+ "press 2: To Get User Exam Status\n"
				+ "press 3: To Get Score Of A user\n"
				+ "press 4: To start The Test \n"
				+ "press 5: To Exit from the menu \n");
		int choice= scanner.nextInt();
		
		switch (choice) {
		case 1:
				new UserService().addUser();
			break;
		case 2:
				new UserService().getUser();
			break;
		case 3:
				new UserService().getScore();
			break;
		case 4:
				new UserService().startTest();
			break;
		case 5: System.out.println(" Thank You ");
		        scanner.close();
		        System.exit(0);
		default:System.out.println(" Enter a valid choice ");
			break;
		}
		
	}while(true);
		 
    }
}
