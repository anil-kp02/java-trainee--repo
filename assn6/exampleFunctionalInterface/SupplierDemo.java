package com.assn6.exampleFunctionalInterface;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<Integer> generate=()-> new Random().nextInt(100);
		System.out.println(" Random Number Generate by Supplier is :"+generate.get());
	}

}
