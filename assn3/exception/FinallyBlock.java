package com.assn3.exception;

public class FinallyBlock {
	public static void main(String[] args) {
		try {
			int []array=new int[5];
			array[5]=10;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		finally {
			System.out.println("finaly block is invoked after the exception handled");
		}
		
		try {
			int a=5/0;
		}
		finally {
			System.out.println("finaly block is invoked even if  the exception is not handled");
		}
	}

}
