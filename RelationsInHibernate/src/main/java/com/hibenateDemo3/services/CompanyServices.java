package com.hibenateDemo3.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.hibenateDemo3.dao.CompanyDao;
import com.hibenateDemo3.dto.EmployeeDto;


public class CompanyServices {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	CompanyDao companyDao= new CompanyDao();
	
	public void addCompany() {
		System.out.println(" enter company Name :");
		try{
			companyDao.addNewCompany(reader.readLine());
			System.out.println("added");
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	// All employees inside a company
	public void getEmployees() {
	    System.out.println("Enter company Name: ");
	    try {
	       
	        String companyName = reader.readLine().trim();
	        
	        	        if (companyName.isEmpty()) {
	            System.out.println("Company name cannot be empty.");
	            
	        }

	        List<EmployeeDto> list = companyDao.getCompanyEmployee(companyName);
	        
	        if (list.isEmpty()) {
	            System.out.println("No Employees in this company.");
	        } else {
	            System.out.println("Employees in company: " + companyName);
	            list.forEach(employee -> System.out.println(employee));
	        }
	    } catch (Exception e) {
	        System.err.println("An error occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	  //delete Company 
	  public void deleteCompany() {
		  System.out.println(" Enter company name :");
		  try{
			  int affectedRow =companyDao.deleteCompany(reader.readLine());
			  if(affectedRow ==0 ) {
				  System.out.println(" No record deleted");
			  }
			  else {
				  System.out.println(" Deleted company");
			  }
		  }catch(Exception e) {
			  e.getMessage();
		  }
	  }
}
