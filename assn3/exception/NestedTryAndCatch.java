package com.assn3.exception;

public class NestedTryAndCatch {
	public static void main(String[] args) {
		try {
			try {
				int a=10/0;
			}catch(ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			int []array=new int[5];
			array[6]=100;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
