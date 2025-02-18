package com.assn6.exampleFunctionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
	public static void main(String[] args) {
		UnaryOperator<Integer> multiply10=a->a*10;
		
		System.out.println(" 10 Multiplication of 145 is :"+multiply10.apply(145));
	}

}
