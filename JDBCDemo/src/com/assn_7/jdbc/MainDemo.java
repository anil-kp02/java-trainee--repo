package com.assn_7.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDemo {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static Statement stmt;
	static Connection con=JdbcConnection.getConnection();
	
	/*
	 * private static Connection getConnection() { return
	 * JdbcConnection.getConnection(); }
	 */
	static void insert() throws SQLException, IOException {
		String dynamicQ= "insert into employee(name,email) values (?,?)";
		PreparedStatement pstmt=con.prepareStatement(dynamicQ);
		System.out.println(" Enter name of the Employee :");
		pstmt.setString(1,br.readLine());
		
		System.out.println(" Enater Email : ");
		pstmt.setString(2, br.readLine());
		
		pstmt.executeUpdate();
		System.out.println(" Inserted ");
	}
	
	static void delete() throws SQLException, NumberFormatException, IOException {
		 String deleteQ= " delete From employee where id=?";
    	 PreparedStatement pstmtD=con.prepareStatement(deleteQ);
    	 System.out.println(" Enter the id of the Employee : ");
     	 int did = Integer.parseInt(br.readLine());
     	 pstmtD.setInt(1, did);
    	
    	 int k= pstmtD.executeUpdate();
    	 System.out.println(" Deleted !! "+k);
	}
	
	static void read() throws SQLException {
		String readQ= "select * from employee";
		stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(readQ);
		System.out.println(" Deatils :");
		while (rs.next()) {   // act as cursor visit each element one by one 
		System.out.println(" id :" + rs.getInt("id") +
				"Name : "+ rs.getString("name")+
				" Email:  "+rs.getString("email"));}
	}
	
	static void update() throws NumberFormatException, IOException, SQLException {
		System.out.println(" Enter the id of the Employee : ");
     	int uid = Integer.parseInt(br.readLine());
    	System.out.println(" Enter what do You want to update : \n press 1 : name \n press 2 : Email \n ");
     	int optn=Integer.parseInt(br.readLine());
     	
     	if(optn==1) { // update name 
     		String queryUN=" update employee Set name= ? where id =?";
     		PreparedStatement pstmtUN=con.prepareStatement(queryUN);
     		pstmtUN.setInt(2, uid);
     		System.out.println(" Enter Updated Name : ");
     		pstmtUN.setString(1, br.readLine());
     		int i=pstmtUN.executeUpdate();
     		System.out.println(" Updated !! "+ i);
     	}
     	else if(optn==2) { //update email
     		String queryUE = "update employee set email=? where id =?";
     		PreparedStatement pstmtUE=con.prepareStatement(queryUE);
     		pstmtUE.setInt(2, uid);
     		System.out.println(" Enter the updated email : ");
     		pstmtUE.setString(1, br.readLine());
     		int j= pstmtUE.executeUpdate(); 
     		System.out.println(" Updated !! "+j);
     	}
     	else {
     		System.out.println(" Invalid Input");
     	}
	}
public static void main(String[] args) throws SQLException, NumberFormatException, IOException ,NullPointerException{
	//Connection con=JdbcConnection.getConnection(); 
	Statement st= con.createStatement();
	System.out.println(" update");
	update();
}
}
