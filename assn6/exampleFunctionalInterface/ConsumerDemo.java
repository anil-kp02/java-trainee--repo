package com.assn6.exampleFunctionalInterface;

import java.util.function.Consumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		Consumer<String> consume=a-> System.out.println(a);
		
		consume.accept("Anil");

	}

}
