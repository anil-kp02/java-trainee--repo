package com.assn4.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemoveList {
public static void main(String[] args) {
	List<Integer> number=new ArrayList<>();
	number.add(5);
	number.add(13);
	number.add(321);
	number.add(124);
	number.add(25);
	number.add(321);
	number.add(21);
	number.add(5);
	
	Set<Integer> unique=new HashSet<>(number);
	System.out.println("Unique numbers are :"+unique);
}
}
