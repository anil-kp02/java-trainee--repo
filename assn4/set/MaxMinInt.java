package com.assn4.set;

//import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MaxMinInt {
	public static int maximum(Set<Integer> number) {
		int max =Integer.MIN_VALUE;
		for(Integer num:number) {
			if(max<num) {
				max=num;
			}
		}
		
		return max;
		
		
	}
	
	public static int minimum(Set<Integer> number) {
		int min=Integer.MAX_VALUE;
		for(Integer num:number) {
			if(min>num) {
				min=num;
			}
		}
		return min;
		
	}
public static void main(String[] args) {
	Set<Integer> number=new HashSet<>();
	number.add(5);
	number.add(13);
	number.add(321);
	number.add(124);
	number.add(25);
	number.add(321);
	number.add(21);
	number.add(5);
	
	System.out.println("Maximum value is :"+maximum(number));
	System.out.println("Maximum value is :"+minimum(number));
	
}
}
