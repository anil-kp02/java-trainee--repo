package com.vehicleManagementSystem;

import java.util.Scanner;


import com.vehicle.controller.VehicleController;
import com.vehicle.resources.ConnectionProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
    	do {
    		System.out.println(" ------------------------------------------------\n"
    				+ " VEHICLE SERVICES    \n"
    				+ " press 1 : Add a new vehicles \n"
    				+ " press 2 : View all Vehicles \n"
    				+ " press 3 : View vehicles by Id \n"
    				+ " press 4 : Update vehicle Details (Ownnership change / Colour Change) \n"
    				+ " Press 5 : Delete Vehicle Details \n"
    				+ " Press 6 : Exit \n");
    		int choice= scanner.nextInt();
    		
    		switch (choice) {
			case 1: VehicleController.addVehicle();
				break;
			case 2: VehicleController.getAllVehicles();
				break;
			case 3: VehicleController.getVehicleById();
				break;
			case 4: VehicleController.updateVehicle();
				break;
			case 5: VehicleController.deleteVehicle();
				break;
			case 6: ConnectionProvider.closeFactory();
					System.out.println(" thank You ");
					System.exit(0);
				break;

			default: System.out.println(" Enter a valid Input !!!!");
				break;
			}
    		
    	}while(true);
    	
    	
    }
    
}
