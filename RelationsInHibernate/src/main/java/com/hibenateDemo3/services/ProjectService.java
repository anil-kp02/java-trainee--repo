package com.hibenateDemo3.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hibenateDemo3.dao.ProjectDao;
import com.hibenateDemo3.dto.ProjectDto;

public class ProjectService {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ProjectDao projectDao = new ProjectDao();

	// Get All Projects
	public void getAllProject() {
		List<ProjectDto> list = projectDao.getAllProject();
		list.stream().forEach(project -> System.out.println(project.getProjectName()));
	}

	// to add Project
	public void addProject() {
		System.out.println(" Enter Project Name : ");
		try {
			projectDao.addProject(new ProjectDto(reader.readLine(), null));
			System.out.println(" Added sucessfully ");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// add employess to a project
	/*
	 * public void addEmployeeToProject () { try {
	 * System.out.println(" Enter the Project Id :"); Integer projectId=
	 * Integer.parseInt(reader.readLine()); if(projectDao.getProjectById(projectId)
	 * != null) { List<Integer> employeeIds= new ArrayList<>();
	 * System.out.println(" Enter how many Employee You want to add : "); int
	 * size=Integer.parseInt(reader.readLine()); for(int i=0;i<size;i++) {
	 * System.out.println(" Enter the employe No : " +(i+1)); int id =
	 * Integer.parseInt(reader.readLine()); employeeIds.add(id);
	 * 
	 * } projectDao.addEmployee(projectId, employeeIds);
	 * System.out.println(" Added sucessFully ");
	 * 
	 * }else { System.out.println(" No project Exist"); }
	 * 
	 * 
	 * 
	 * }catch(Exception e) { e.getMessage(); } }
	 */
	/*
	 * public void addEmployeeToProject() { try {
	 * 
	 * System.out.println("Enter the Project ID:"); Integer projectId =
	 * Integer.parseInt(reader.readLine());
	 * 
	 * if (projectDao.getProjectById(projectId) != null) {
	 * 
	 * List<Integer> employeeIds = new ArrayList<>();
	 * System.out.println("Enter how many employees you want to add:"); int size =
	 * Integer.parseInt(reader.readLine());
	 * 
	 * for (int i = 0; i < size; i++) {
	 * System.out.println("Enter the employee number " + (i + 1) + " ID:"); int id =
	 * Integer.parseInt(reader.readLine()); employeeIds.add(id); }
	 * 
	 * projectDao.addEmployee(projectId, employeeIds);
	 * System.out.println("Employees added successfully to the project.");
	 * 
	 * } else { System.out.println("No project exists with ID: " + projectId); // If
	 * the project doesn't exist }
	 * 
	 * } catch (NumberFormatException e) {
	 * System.out.println("Invalid input. Please enter a valid number."); } catch
	 * (Exception e) { System.out.println("An error occurred: " + e.getMessage());
	 * e.printStackTrace(); } }
	 */
	public void addProjectAndEmployee() {
		try {

			System.out.println("Enter the Project name:");
			String projectName = reader.readLine();

			List<Integer> employeeIds = new ArrayList<>();
			System.out.println("Enter how many employees you want to add:");
			int size = Integer.parseInt(reader.readLine());

			for (int i = 0; i < size; i++) {
				System.out.println("Enter the employee number " + (i + 1) + " ID:");
				int id = Integer.parseInt(reader.readLine());
				employeeIds.add(id);
			}

			projectDao.addProjectAndEmploye(projectName, employeeIds);
			System.out.println("Employees added successfully to the project.");

		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid number.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// to view Project
	public void viewAllProject() {
		List<ProjectDto> list = projectDao.getAllProject();
		if (list.isEmpty()) {
			System.out.println(" No projects are there ");
		} else {
			list.stream().forEach(project -> System.out.println(project.getProjectName()));
		}
	}

	// getProject byId
	/*
	 * public void getProjectById() { try {
	 * System.out.println(" Enter Project Id "); Integer id =
	 * Integer.parseInt(reader.readLine()); ProjectDto projectDto =
	 * projectDao.getProjectById(id); if(projectDto == null){
	 * System.out.println(" No Projects are there "); } else {
	 * System.out.println(projectDto); } }catch (Exception e) { e.getMessage(); } }
	 */
	public void getProjectById() {
		try {
			System.out.println("Enter Project Id: ");
			Integer id = Integer.parseInt(reader.readLine());
			ProjectDto projectDto = projectDao.getProjectById(id);

			if (projectDto == null) {
				System.out.println("No project found with ID: " + id);
			} else {
				System.out.println("Project Details: " + projectDto);
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid integer ID.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteProjet() {
		try {
			System.out.println(" Enter the id Of the Project : ");
			int flag = projectDao.deleteProject(Integer.parseInt(reader.readLine()));
			if (flag == 1) {
				System.out.println(" Delete sucessFully !!");
			} else {
				System.out.println(" No Project In this Id ");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
