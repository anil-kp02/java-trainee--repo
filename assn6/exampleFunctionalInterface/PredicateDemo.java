package com.assn6.exampleFunctionalInterface;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> isAdult=a->a>18;
		
		Scanner sc = new  Scanner(System.in);
		System.out.println(" Enter the Age :");
		
		System.out.println(" You are Eligible to vote :"+ isAdult.test(sc.nextInt()));
	}

}
