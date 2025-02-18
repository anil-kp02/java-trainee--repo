package com.assn5.queueImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class TicketCounter {
	static Queue<String> ticketLine=new LinkedList<>();
	public static void add() {
		for(int i=0;i<10;i++) {
			ticketLine.add("Person"+(i+1));
		}
	}
	public static void main(String[] args) {
		System.out.println(" The Order is :");
		add();
		while(!ticketLine.isEmpty()) {
			System.out.println(" Served  "+ticketLine.remove());
		}
		
	}

}
