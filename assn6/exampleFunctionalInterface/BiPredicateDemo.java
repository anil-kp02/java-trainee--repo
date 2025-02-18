package com.assn6.exampleFunctionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
public static void main(String[] args) {
	BiPredicate<Integer, Integer> greaterNum= (a,b)->a>b;
	
	System.out.println(" First Num is greater Than Second : "+greaterNum.test(102, 109));
}
}
