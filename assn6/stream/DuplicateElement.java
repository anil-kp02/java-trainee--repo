package com.assn6.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElement {
public static void main(String[] args) {
	List<Integer> list= Arrays.asList(14,33,21,67,90,42,25,33,90);
	Map<Object, Long> map=list.stream().collect(Collectors.groupingBy((x)->x,Collectors.counting()));
	
	// map.entrySet().stream().filter(x->x.getValue()==1).collect(Collectors.toList());
	
	System.out.println(" Distinct Numbers are :"+map.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).collect(Collectors.toList()));
	map.entrySet().forEach(x->{
		if(x.getValue()!=1)
			System.out.println(x.getKey());
		}
	);
	
}
}
