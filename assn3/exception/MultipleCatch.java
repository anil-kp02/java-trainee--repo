package com.assn3.exception;

public class MultipleCatch {
	public static void main(String[] args) {
		try {
			int a=5/0;
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
