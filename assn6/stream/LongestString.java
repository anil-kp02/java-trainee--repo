package com.assn6.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestString {
public static void main(String[] args) {
	List<String> word=Arrays.asList("anil","subham","Satya","Abhishek");
	
	word.stream().collect(Collectors.maxBy((a,b)->a.length()-b.length()));
	
	System.out.println("The Word having maximum length : "+word.stream().collect(Collectors.maxBy((a,b)->a.length()-b.length())));
}
}
