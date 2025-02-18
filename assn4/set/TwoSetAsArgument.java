package com.assn4.set;

import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

public class TwoSetAsArgument {
	public static Set<Integer> merge(Set<Integer> number1,Set<Integer>number2){
		return number1;
	}
	public static void main(String[] args) {
		Set<Integer> number1=new HashSet<>();

		number1.add(100);
		number1.add(200);
		number1.add(50);
		number1.add(540);
		number1.add(60);
		
		Set<Integer> number2=new HashSet<>();
		
		number2.add(230);
		number2.add(100);
		number2.add(50);
		number2.add(200);
		number2.add(111);
		
		System.out.println(merge(number1, number2));
		
	}

}
