package com.assn6.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PArtionNumbers {
public static void main(String[] args) {
	List<Integer> list= Arrays.asList(14,33,21,67,90,42,25);
	
	 list.stream().collect(Collectors.partitioningBy(x->x%2==0));
	 System.out.println(list.stream().collect(Collectors.partitioningBy(x->x%2==0)));
}
}
