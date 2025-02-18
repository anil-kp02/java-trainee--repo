package com.assn_7.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//3. Using Prepared Statement Interface, Perform CRUD operations using dynamic values 
//(This should be menu driven. User should choose what operation he wants to perform).
public class DynamicCRUD {
public static void main(String[] args) throws SQLException, ClassNotFoundException, NumberFormatException, IOException {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Admin@123");
	System.out.println(" Connection Established ");
	Statement stmt= con.createStatement();
	
	do {
		System.out.println(" CRUD MENU  \n Press 1 : Insert \n press 2 : Read \n press 3 : Update \n "
				+ "press 4 : Delete \n press 5 : Exit");
		int choice=Integer.parseInt(br.readLine());
		switch(choice) {
		case 1: String dynamicQ= "insert into employee(name,email) values (?,?)";
			PreparedStatement pstmt=con.prepareStatement(dynamicQ);
			System.out.println(" Enter name of the Employee :");
			pstmt.setString(1,br.readLine());
			
			System.out.println(" Enater Email : ");
			pstmt.setString(2, br.readLine());
			
			pstmt.executeUpdate();
		 break;
		// read
		case 2:
			String readQ= "select * from employee"; 
			ResultSet rs = stmt.executeQuery(readQ);
			System.out.println(" Deatils :");
			while (rs.next()) {   // act as cursor visit each element one by one 
			System.out.println(" id :" + rs.getInt("id") +
					"Name : "+ rs.getString("name")+
					" Email:  "+rs.getString("email"));}
	      break;
	    
	    // Update via employee id 
	     case 3:
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
	      break;
	     
	      // delete by id 
	     case 4:
	    	 String deleteQ= " delete From employee where id=?";
	    	 PreparedStatement pstmtD=con.prepareStatement(deleteQ);
	    	 System.out.println(" Enter the id of the Employee : ");
	     	 int did = Integer.parseInt(br.readLine());
	     	 pstmtD.setInt(1, did);
	    	
	    	 int k= pstmtD.executeUpdate();
	    	 System.out.println(" Deleted !! "+k);
	     break;
	     
	     //Exit from Menu 
	    case 5: con.close();
	    	System.exit(0);
	    
	    default: System.out.println(" Invalid choice please choice again : ");
		}
		
		
	}while(true);
	
	
}

}
