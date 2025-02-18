package com.assn5.queueImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class CallCenterCustomerHandling {
	static Deque<String> queue=new LinkedList<>();
	
	//Add Normal Customer 
	public static void addNormalCustomer(String customer) {
		queue.add(customer);
		System.out.println("Added SucessFully  ");
	}
	
	// Add VIP Customer 
	
	public static void addVIP(String customer) {
		queue.addFirst(customer);
		System.out.println("VIP added Sucess Fully ");
	}
	
	//Handle Customer 
	
	public static void handleCustomer() {
		if(!queue.isEmpty()) {
			System.out.println(" Customer handeled "+queue.remove());
		}
		else {
			System.out.println(" All Customer are Altredy Handled : ");
		}
	}
	
	// Display Queue
	public static void display() {
		for(String element:queue) {
			System.out.println(element);
		}
		if(queue.isEmpty()) {
			System.out.println(" Noting to Display");
		}
	}
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			do {
				System.out.println("Enter Choice to Perform Action : \n"
						+ "press 1. Add Normal Customer\n"
						+ "press 2. Add vip Customer\n"
						+ "Press 3. Handel Next Customer \n"
						+ "Press 4. Display Qeue\n"
						+ "Press 5.exit");
				int choice =Integer.parseInt(br.readLine());
				
				switch (choice) {
				case 1:System.out.println(" Customer details :");
					addNormalCustomer(br.readLine());
				  break;
				case 2:System.out.println(" Enter vip Custome Details : ");
					addVIP(br.readLine());
					break;
				case 3:handleCustomer();
				    break;
				case 4:display();
				    break;
				case 5: System.exit(0);

				default:System.out.println(" Invalid Input");
				}
				
			}while(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
