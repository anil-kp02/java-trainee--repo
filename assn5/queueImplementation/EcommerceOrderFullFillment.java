package com.assn5.queueImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class EcommerceOrderFullFillment {
	static Deque<String> orders=new LinkedList<>();
	
	//Add Order 
	public static void addOrder(String order) {
		orders.add(order);
		System.out.println(" Added SucessFully");
	}
	//Process Order
	public static void ProcessOrder() {
		if(orders.isEmpty()) {
			System.out.println(" All Orders are Processed .");
		}
		else {
			System.out.println( orders.remove()+" Order is handles");
		}
	}
	// add prioritize Order
	public static void addPrioritizeOrder(String order) {
		orders.addFirst(order);
		System.out.println(" Added SucessFully");
	}
	
public static void main(String[] args) {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	try {
		do {
			System.out.println("Enter Choice to Perform Action : \n"
					+ "press 1. Add Normal Order\n"
					+ "press 2. Add Priortize Order\n"
					+ "Press 3. Handel Order \n"
					+ "Press 4. Exit\n");
			int choice =Integer.parseInt(br.readLine());
			
			switch (choice) {
			case 1:System.out.println(" Enter Order Details  :");
				addOrder(br.readLine());
			  break;
			case 2:System.out.println(" Enter priortize order Details : ");
				addPrioritizeOrder(br.readLine());
				break;
			case 3:ProcessOrder();
			    break;
			
			case 4: System.exit(0);

			default:System.out.println(" Invalid Input");
			}
			
		}while(true);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
