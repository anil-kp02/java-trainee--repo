package com.assn6.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUpperCAse {
public static void main(String[] args) {
	List<String> word=Arrays.asList("anil","subham sahoo","Satya","Abhishek");
	
	List<String> modifie=word.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
	System.out.println(" Uper Case Strings are");
	modifie.forEach(x->System.out.println(x));
	
	System.out.println(word.stream().collect(Collectors.groupingBy(String::length)));
	
	System.out.println(word.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(" , "))));
	
	System.out.println(word.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
	
	word.stream().collect(Collectors.mapping(x->x.toLowerCase(), Collectors.toList()));
	System.out.println(word.stream().collect(Collectors.mapping(x->x.toLowerCase(), Collectors.toList())));
	
}
}
