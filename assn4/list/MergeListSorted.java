package com.assn4.list;

import java.util.ArrayList;
import java.util.List;

public class MergeListSorted {
public static void main(String[] args) {
	List<Integer> number1=new ArrayList<>();

	number1.add(100);
	number1.add(200);
	number1.add(50);
	number1.add(540);
	number1.add(60);
	
	List<Integer> number2=new ArrayList<>(number1);
	
	number2.add(230);
	number2.add(100);
	number2.add(50);
	number2.add(200);
	number2.add(111);
	
	number2.sort(null);
	System.out.println("After Operation Complete :"+number2);
}
}
