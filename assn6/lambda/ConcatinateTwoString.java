package com.assn6.lambda;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConcatinateTwoString {
public static void main(String[] args) {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	Concatinate concatinate = (str1,str2)->str1+str2;
	
	try {
		System.out.println(" Enter first String :");
		String str1=br.readLine();
		System.out.println(" Enter second  String :");
		String str2=br.readLine();
		
		System.out.println(" Result is "+concatinate.concatinate(str1, str2));
		
	}catch(Exception e) {
		
	}
}
}
