package com.assn6.exampleFunctionalInterface;

import java.util.function.BiConsumer;

public class BiconsumerDemo {
public static void main(String[] args) {
	BiConsumer<String, Integer> biconsume=(a,b)->System.out.println("Student name :"+a +
			"  Student Id :"+b);
	
	biconsume.accept("Anil", 60);
}
}
