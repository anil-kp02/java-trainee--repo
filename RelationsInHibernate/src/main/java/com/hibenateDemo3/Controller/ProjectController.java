package com.hibenateDemo3.Controller;

import java.util.Scanner;

import com.hibenateDemo3.services.ProjectService;

public class ProjectController {
	ProjectService projectService = new ProjectService();
	
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		
		do {
			System.out.println(" ++++++++++++++++++++++++++++++++++++++++++\n"
					+ "              Project MENU             \n"
					+ "  ----------------------------------------------\n"
					+ "		1: To add Project\n"
					+ "		2: To Get Project By Id\n"
					+ " 	3: To get All All Project\n"
					+ "		4: To delete Project\n"
					+ "		5: To Add employee And  Project\n"
					+ "		6: To Exit");
			
			System.out.println(" Enter The choice : ");
			switch (scanner.nextInt()) {
			case 1: projectService.addProject();
				
				break;
			case 2: projectService.getProjectById();
				break;
			case 3: projectService.getAllProject();
				break;
			case 4: projectService.deleteProjet();
				break;
			case 5:projectService.addProjectAndEmployee();
				break;
			case 6:
				System.out.println(" Out of Project Menu ");
				scanner.close();
				flag=false;

			default: System.out.println(" Enter valid choice !!");
				break;
			}
			
		}while(flag);
		
	}
	}


