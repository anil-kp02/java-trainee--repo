package com.assn_7.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//5. Write a JDBC Program using prepared statement, that performs User sign up, and sign in. User email should be unique. Print Invalid credentials, if user enters wrong credentials. 
//(Menu Driven Program). This is menu driven program (User will choose if he wants to sign up or sign in).
public class SignInSignUp {
public static void main(String[] args) throws SQLException, ClassNotFoundException, NumberFormatException, IOException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Admin@123");
	System.out.println(" Connection Established ");	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	do {
		System.out.println(" USer Input ::::: \n press 1: sign in \n press 2: sign up ");
		int choice=Integer.parseInt(br.readLine());
		
		switch (choice) {
		case 1: PreparedStatement pstmt= con.prepareStatement("insert into user_credential(email,password) values (?,?)");
			System.out.println(" Enter email as user name : ");
			pstmt.setString(1, br.readLine());
			System.out.println(" Enter a password : ");
			pstmt.setString(2, br.readLine());
			int i= pstmt.executeUpdate();
			if(i==1) {
				System.out.println(" Registered sucessfully !!!");
			}
			
			break;
		// sign in 
		case 2: PreparedStatement pstmtin=con.prepareStatement("select * from user_credential where email=?");
			System.out.println(" Enter user name(email)  : ");
			pstmtin.setString(1, br.readLine());
			ResultSet rs =pstmtin.executeQuery();
			System.out.println(" Enter password : ");
			String pswrd=br.readLine();
			if(rs.next()) {
				if(rs.getString(3).equals(pswrd)) {
					System.out.println(" Welcome ...!!!!");
					System.exit(0);
				}
				else {
					System.out.println(" Incorrect Paswrd ");
				}
			}
			else {
				System.out.println(" Invalid credentials ");
			}
			break;
		//exit 
		case 3: con.close();
		System.exit(0);

		default: System.out.println(" ERROR ");
			break;
		}
		
	}while(true);
}
}
