package com.assn_7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//4. Write a jdbc program that shows autoCommit() and commit() works.
public class CommiteVSAutoCommite {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Admin@123");
	System.out.println(" Connection Established ");
	Statement st= con.createStatement();
	
	// Auto commit 
	// All these two query is individual transaction  
	con.setAutoCommit(true);
	String insertq1 = "insert into employee(name,email) values ('Ashis sahoo' ,'subhamvirus@gmail.com')";
	int i=st.executeUpdate(insertq1);
	System.out.println(i);
	String insertq2 = "insert into employee(name,email) values ('Harish  ' ,'subhri.com')";
	int j =st.executeUpdate(insertq2);
	System.out.println(j);
	
	System.out.println(" transaction complete ");
	
	
	// commit 
	//query 3, and 4 considers as single transaction 
	con.setAutoCommit(false);
	String insertq3 = "insert into employee(name,email) values ('Abhinab  sahoo' ,'abhidds@gmail.com')";
	int k=st.executeUpdate(insertq3);
	System.out.println(k);
	String insertq4 = "insert into employee(name,email) values ('Harish harshabardhan  ' ,'subhrigrsday.com')";
	int l=st.executeUpdate(insertq4);
	System.out.println(l);
	con.commit();
	con.close();
	System.out.println(" After commit Connection is closed :");
}
}
