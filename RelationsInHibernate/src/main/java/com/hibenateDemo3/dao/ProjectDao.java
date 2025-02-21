package com.hibenateDemo3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibenateDemo3.dto.EmployeeDto;
import com.hibenateDemo3.dto.ProjectDto;
import com.hibenateDemo3.entity.Employee;
import com.hibenateDemo3.entity.Project;
import com.hibenateDemo3.resources.ConnectionProvider;

public class ProjectDao {
	// static SessionFactory factory;

	// adding a new project
	public void addProject(ProjectDto projectDto) {
		Session session = ConnectionProvider.getFactory().openSession();
		session.beginTransaction();
		Project project = new Project();
		project.setProjectName(projectDto.getProjectName());
		session.save(project);
		session.getTransaction().commit();
		session.close();

	}

	public List<ProjectDto> getAllProject() {
		Session session = ConnectionProvider.getFactory().openSession();
		List<Project> list = session.createQuery("from Project", Project.class).getResultList();

		List<ProjectDto> resultList = list.stream()
				.map(project -> new ProjectDto(project.getProjectName(), project.getEmployees()))
				.collect(Collectors.toList());
		session.close();
		return resultList;

	}

	/*
	 * public void addEmployee(Integer projectId, List<Integer> employeeIds) {
	 * Session session = ConnectionProvider.getFactory().openSession(); Transaction
	 * transaction = null;
	 * 
	 * try {
	 * 
	 * transaction = session.beginTransaction();
	 * 
	 * Project project = session.get(Project.class, projectId);
	 * 
	 * if (project == null) { System.out.println("No project found with ID: " +
	 * projectId); return; }
	 * 
	 * List<Employee> employees = new ArrayList<>(); for (Integer employeeId :
	 * employeeIds) { Employee employee = session.get(Employee.class, employeeId);
	 * 
	 * if (employee != null) { employees.add(employee); } else {
	 * System.out.println("No employee found with ID: " + employeeId); } }
	 * 
	 * project.setEmployees(employees); session.persist(project);
	 * 
	 * transaction.commit(); } catch (Exception e) { if (transaction != null) {
	 * transaction.rollback(); } System.out.println("An error occurred: " +
	 * e.getMessage()); e.printStackTrace(); } finally { session.close(); } }
	 */
	
	public void addProjectAndEmploye(String projectName,List<Integer> employeeIds) {
		  Session session = ConnectionProvider.getFactory().openSession();
		   
		    try {
		        
		        session.beginTransaction();
		        
		        Project project = new Project();
		        project.setProjectName(projectName);
		        
		        List<Employee> employees = new ArrayList<>();
		        for (Integer employeeId : employeeIds) {
		            Employee employee = session.get(Employee.class, employeeId);

		            if (employee != null) {
		            	employee.setProjects(project);
		                employees.add(employee);
		            } else {
		                System.out.println("No employee found with ID: " + employeeId);
		            }
		        }
		        
		        project.setEmployees(employees);
		        session.persist(project);

		        session.getTransaction().commit();
		    } catch (Exception e) {
		       
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
	}

	public List<EmployeeDto> getEmployeesOfAProject(Integer projectId) {
		Session session = ConnectionProvider.getFactory().openSession();
		Project project = session.get(Project.class, projectId);
		List<EmployeeDto> resultList= project.getEmployees().stream().map(employee->EmployeeDto.entityToDto(employee)).collect(Collectors.toList());
		return resultList;
	}
	/*
	 * public ProjectDto getProjectById(Integer id ) { Session session =
	 * ConnectionProvider.getFactory().openSession(); Project project =
	 * session.get(Project.class, id); ProjectDto projectDto =
	 * ProjectDto.entityToDto(project); session.close(); return projectDto; }
	 */
	public ProjectDto getProjectById(Integer id) {
	    Session session = null;
	    ProjectDto projectDto = null;
	    
	    try {
	        session = ConnectionProvider.getFactory().openSession();
	        Project project = session.get(Project.class, id);

	        if (project != null) {
	            projectDto = ProjectDto.entityToDto(project);
	        } else {
	            System.out.println("No project found with ID: " + id);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("An error occurred while retrieving the project: " + e.getMessage());
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    
	    return projectDto;
	}

	
	public Integer deleteProject(Integer projectId) {
		Session session = ConnectionProvider.getFactory().openSession();
		
		Project project= session.get(Project.class, projectId);
		if(project != null) {
			session.beginTransaction();
			session.delete(project);
			session.getTransaction().commit();
			session.close();
			return 1;
		}
		else {
			session.close();
			return 0;
		}
	}
	
}
