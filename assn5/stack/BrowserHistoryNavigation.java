package com.assn5.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BrowserHistoryNavigation {
	static Stack<String> back=new Stack<>();
	static Stack<String> forward=new Stack<>();
	private static String current_page;
	
	//Visit A new Web side
	public static void visit(String page) {
		if(current_page==null) {
			current_page=page;
		}
		else {
			back.push(current_page);
			current_page=page;
		}
		
		
		System.out.println(" Browsed sucessFully :"+current_page);
	}
	
	//go-back in browser(undo)
	public static String goBack() {
		if(!back.isEmpty()) {
			forward.push(current_page);
			current_page=back.pop();
			return current_page;
		}
		else {
			System.out.println(" UnderFlow");
			return null;
		}
		
	}
	
	//Go forward (redo)
	public static String goForward() {
		if(!forward.isEmpty()) {
			back.push(current_page);
			current_page=forward.pop();
			return current_page;
		}
		else {
			System.out.println(" No Page Available to be Forwarded");
			return null;
		}
		
	}
	
	public static String showCurrentPage() {
		return current_page;
	}
	
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			do {
				System.out.println(" ---------------------------------------------------");
				System.out.println("               NAVIGATIONS               ");
				System.out.println(" ---------------------------------------------------");
				System.out.println(" Enter the choice :   \n"
						+ "press 1.Visit a new Page \n"
						+ "press 2.Go Back(<-) \n"
						+ "press 3.Go Forward(->)\n"
						+ "Press 4.Show CurrentPage\n"
						+ "press 5.Exit");
				int choice =Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:System.out.println(" Enter the Page NAme :");
					visit(br.readLine());
					
					break;
				case 2:System.out.println(" Previous Page is :"+goBack());
				    break;
				case 3:System.out.println(" Next Page is :"+goForward());
				    break;
				case 4:System.out.println("The current page is :"+showCurrentPage());    
				    break;
				case 5: System.exit(0);

				default:System.out.println("Invalid choice ");
				}
				
			}while(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
