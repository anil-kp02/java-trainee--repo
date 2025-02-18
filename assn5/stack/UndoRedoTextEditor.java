package com.assn5.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class UndoRedoTextEditor {
	static Stack<String> undo=new Stack<>();
	static Stack<String> redo= new Stack<>();
	static String currentString;
	
	public static void write(String page) {
		if(currentString==null) {
			currentString=page;
		}
		else {
			undo.push(currentString);
			currentString=page;
		}
		
		
		//System.out.println(" Browsed sucessFully :"+currentString);
	}
	public static String undo() {
		if(!undo.isEmpty()) {
			redo.push(currentString);
			currentString=undo.pop();
			return currentString;
		}
		else {
			System.out.println(" UnderFlow");
			return null;
		}
		
	}
	public static String redo() {
		if(!redo.isEmpty()) {
			undo.push(currentString);
			currentString=redo.pop();
			return currentString;
		}
		else {
			System.out.println(" OverFlow");
			return null;
		}

}
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			do {
				System.out.println(" Enter the Choice 1.write\n 2.undo\n 3.Redo\n4.Exit");
				int choice =Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:write(br.readLine());
				    break;
				case 2:System.out.println(undo()); 
				   break;
				case 3:System.out.println(redo());
				   break;
				case 4: System.exit(0);
					
					

				default:System.out.println(" inVAlid");
					
				}
			}while(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
