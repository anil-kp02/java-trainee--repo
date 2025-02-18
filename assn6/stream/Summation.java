package com.assn6.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Summation {
public static void main(String[] args) {
	List<Integer> list= Arrays.asList(14,33,21,67,90,42);
	IntSummaryStatistics stats=list.stream().collect(Collectors.summarizingInt(x->x));
	
	
	System.out.println(" Sum of the element is :"+stats.getSum());
}
}
