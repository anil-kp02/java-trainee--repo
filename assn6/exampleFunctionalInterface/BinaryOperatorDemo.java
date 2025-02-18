package com.assn6.exampleFunctionalInterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
	public static void main(String[] args) {
		BinaryOperator<Integer> greaterNum=(a,b)->{
			if(a>b)
				return a;
			else
				return b;
		};
		
		System.out.println(" Greater number between 10339837 and 1837828 is :"
				+greaterNum.apply(10339837, 1837828));
	}

}
