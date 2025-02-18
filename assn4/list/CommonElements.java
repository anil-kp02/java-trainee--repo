package com.assn4.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElements {
	public static void main(String[] args) {
		List<Integer> number1=new ArrayList<>();
		List<Integer> number2=new ArrayList<>();
		number1.add(100);
		number1.add(200);
		number1.add(50);
		number1.add(540);
		number1.add(60);
		
		number2.add(230);
		number2.add(100);
		number2.add(50);
		number2.add(200);
		number2.add(111);
		
		Set<Integer> common=new HashSet<>();
		
		for(Integer number:number1) {
			for(Integer num:number2) {
				if(number==num) {
					common.add(number);
				}
			}
		}
		System.out.println("Common Elements are :"+common);
		
	}

}
