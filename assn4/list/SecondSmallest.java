package com.assn4.list;

import java.util.ArrayList;
import java.util.List;

public class SecondSmallest {
	public static void main(String[] args) {
		List<Integer> number=new ArrayList<>();
		number.add(5);
		number.add(13);
		number.add(321);
		number.add(124);
		number.add(-5);
		number.add(-10);
		number.add(0);
		number.add(7);
		
		number.sort(null);
		System.out.println("Second smallest element is  :"+number.get(1));
		
	}

}
