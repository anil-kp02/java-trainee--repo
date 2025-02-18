package com.assn3.exception;

public class UncheckedException {
	public static void main(String[] args) {
		try {
		  int []array= {1,2,3};
		  System.out.println(array[4]); //Throw Array Index out of bound exception
		  }catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		  }
		try {
		  String name=null;
		  System.out.println(name.length());//Throw Null Pointer exception
		}catch(NullPointerException e) {
			System.out.println(e.toString());
		}
		
		try {
			String str="abc";
			int number=Integer.parseInt(str);
		}catch(NumberFormatException e) {
			System.out.println(e.toString());
			
		}
		
		try {
			int a=5/0;
		}catch(ArithmeticException e) {
			System.out.println(e.toString());
		}
		
		
		
		
	}

}
