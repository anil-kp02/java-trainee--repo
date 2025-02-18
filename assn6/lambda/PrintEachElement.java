package com.assn6.lambda;

import java.util.Arrays;
import java.util.List;

public class PrintEachElement {
public static void main(String[] args) {
	List<Integer> number=Arrays.asList(1,43,23,54,3,12,90);
	
	Print<Integer> operation=(a)->{
		for (Integer integer : a) {
			System.out.println(integer);
		}
		
	};
	
	System.out.println(" List Elements are :");
	operation.print(number);
}
}
