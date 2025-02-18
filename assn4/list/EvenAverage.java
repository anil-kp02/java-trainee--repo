package com.assn4.list;

import java.util.ArrayList;
import java.util.List;

public class EvenAverage {
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
	
	double count=0;
	double sum=0;
	
	for(Integer num:number) {
		if(num%2==0) {
			sum+=num;
			count++;
		}
	}
	System.out.println("Average of Even Number is :"+(sum/count));
}
}
