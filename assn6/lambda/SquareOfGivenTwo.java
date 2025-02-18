package com.assn6.lambda;

import java.util.Scanner;
import java.util.function.Function;

public class SquareOfGivenTwo {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		Function<Integer,Integer> result=(x)->x*x;
		System.out.println(result.apply(3));
		Square calculation =a->a*a;
		
		System.out.println(" Enter the Number which You want to square :");
		int num=sc.nextInt();
		
		System.out.println(" Square is :"+calculation.square(num));
		
	}

}
