package com.studentGrade.main;

import java.util.Scanner;

import com.studentGrade.controller.StudentController;
import com.studentGrade.resources.ConnectionProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner= new Scanner(System.in);
        do {
        	System.out.println(" +++++++++++++++++++++++++++++++++++\n"
        			+ "               Menu            \n"
        			+ "Press 1: To Add Student \n"
        			+ "press 2: To view All \n"
        			+ "press 3: view By Id \n"
        			+ "press 4: update marks \n"
        			+ "press 5: Delete Student \n"
        			+ "press 6: to view grade wise student data \n"
        			+ "press 7: To Exit ");
        	int choice= scanner.nextInt();
        	switch (choice) {
			case 1: StudentController.addStudent();
				break;
			case 2: StudentController.ViewAll();
				break;
			case 3: StudentController.getStudentById();
				break;
			case 4: StudentController.updateStudent();
				break;
			case 5: StudentController.deleteStudent();
				break;
			case 6: StudentController.getGradeStudent();
				break;
			case 7: ConnectionProvider.closeFactory();
				System.out.println(" Thank You ");
				scanner.close();
				System.exit(0);

			default: System.out.println(" Enter valid input :");
				break;
			}
        	
        }while(true);
    }
}
