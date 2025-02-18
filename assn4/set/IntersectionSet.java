package com.assn4.set;

import java.util.HashSet;
import java.util.Set;

public class IntersectionSet {
	public static Set<Integer> intersectionSet(Set<Integer>set1,Set<Integer>set2){
		Set<Integer> intersect=new HashSet<>();
		for(Integer element1:set1) {
			for(Integer element2:set2) {
				if(element1.equals(element2)) {
					intersect.add(element1);
				}
			}
		}
		return intersect;
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
		
		System.out.println(number1);
		System.out.println(number2);
		
		System.out.println("Intersection Portion is :"+intersectionSet(number1, number2));
	}

}
