package com.assn6.exampleFunctionalInterface;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionDemo {
public static void main(String[] args) {
	Function<String, Integer> calculate=a->a.length();
	
	Scanner sc = new  Scanner(System.in);
	System.out.println(" Enter the Word :");
	
	System.out.println(" Length of the word is "+calculate.apply(sc.nextLine()));
}
}
