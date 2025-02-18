package com.assn_7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//2. Using Statement Interface, Create a table called Employee, and perform static CRUD operations.

public class StaticCRUD {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Admin@123");
			System.out.println(" Connection Established ");

			Statement stmt = con.createStatement();

			// create operation .
			String createStmt = "create table employee(id int primary key auto_increment , name varchar(256) not null , email varchar(256) )";
			// stmt.executeUpdate(createStmt);

			// Insert into employee table
			String insertq1 = "insert into employee(name,email) values ('Anil kumar Pradhan ' ,'anilkp@gmail.com')";
			// stmt.executeUpdate(insertq1); //commented after insertion complete to avoid
			// duplicacy

			String insertq2 = "insert into employee(name,email) values ('Subham Mohanty ' ,'subhamvirus@gmail.com')";
			// stmt.executeUpdate(insertq2);
			System.out.println(" Inserted !!");

			// Read Operation

			String readq = "select * from employee";
			ResultSet rs = stmt.executeQuery(readq);
			System.out.println(" Deatils :");
			while (rs.next()) {   // act as cursor visit each element one by one 
				System.out.println(" id :" + rs.getInt("id") +
						"Name : "+ rs.getString("name")+
						" Email:  "+rs.getString("email"));
			}
			
			//Update Operation
			String updateq="Update employee set email='N/a' where id=2";
			int affectdata= stmt.executeUpdate(updateq);
			System.out.println(" Record affected"+affectdata);
			
			
			//Delete Operation 
			String deleteQ=" delete From employee where id= 2";
			stmt.executeUpdate(deleteQ);
			System.out.println(" Delete sucessfully");
			
			//close the connection
			con.close();

		} catch (Exception e) {

		}
	}
}
