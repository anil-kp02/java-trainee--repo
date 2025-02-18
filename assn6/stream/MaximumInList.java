package com.assn6.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaximumInList {
public static void main(String[] args) {
	List<Integer> list= Arrays.asList(14,33,21,67,90,42);
	IntSummaryStatistics stats=list.stream().collect(Collectors.summarizingInt(x->x));
	System.out.println(stats.getSum());
	
			
	System.out.println(" Max element is :"+stats.getMax());
}
}
