package com.assn_9.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;

import com.assn_9.resources.ConnectionProvider;
import com.assn_9.service.StudentOperations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, IOException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, javax.transaction.RollbackException
    {
        System.out.println( "Project Started" );
        Scanner sc = new Scanner(System.in);
        
       // SessionFactory factory= ConnectionProvider.getFactory();
        //System.out.println(factory); // for checking the connection 
        //StudentOperations.insert();
        //StudentOperations.getAll();
        //StudentOperations.getById();
        //StudentOperations.updateById();
        //StudentOperations.deleteById();
        
        do{
        	System.out.println(" _________________________________________________________\n "
        
        		+ "                         MENU                     \n"
        		+ " ----------------------------------------------------------------\n "
        		+ " 1 : for Insert \n"
        		+ " 2 : Get All Student \n "
        		+ " 3 : Get Student By id \n "
        		+ " 4 : Update By Id \n"
        		+ " 5 : delete By Id \n"
        		+ " 6 : Exit \n  ");
        	
        	int choice=sc.nextInt();
        	
        	switch (choice) {
			case 1: StudentOperations.insert();
				
				break;
			case 2: StudentOperations.getAll();
				break;
			case 3: StudentOperations.getById();
				break;
			case 4: StudentOperations.updateById();
				break;
			case 5: StudentOperations.deleteById();
				break;
			case 6: ConnectionProvider.closeFactory();
			 		System.out.println( " Thank You ");
			 		System.exit(0);
			default: System.out.println(" Invaiid Input !!!");
				break;
			}
        	
        }while(true);
    }
        
}
