package com.assn6.exampleFunctionalInterface;

import java.util.function.BiFunction;

public class BiFunctionDemo {
public static void main(String[] args) {
	BiFunction<Integer, Integer,Integer > sum=(a,b)->a+b;
	
	System.out.println(" Sum Of two Num is :"+sum.apply(101, 105));
}
}
