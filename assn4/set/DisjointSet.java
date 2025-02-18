package com.assn4.set;

import java.util.HashSet;
import java.util.Set;

public class DisjointSet {
	public static boolean isDisjoint(Set<Integer>set1,Set<Integer>set2) {
		for(Integer element1:set1) {
			for(Integer element2:set2) {
				if(element1==element2) {
					return true;
				}
			}
		}
		return false;
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
	
	System.out.println("Two set are disjoint :"+isDisjoint(number1, number2));
}
}
