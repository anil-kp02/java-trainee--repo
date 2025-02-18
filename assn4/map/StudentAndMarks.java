package com.assn4.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentAndMarks {
	public static int maxmark(List<Integer> values) {
		int max=Integer.MIN_VALUE;
		for(Integer value:values) {
			if(value>max) {
				max=value;
			}
		}
		return max;
	}
public static void main(String[] args) {
	Map<String,List<Integer>> studentRecord=new HashMap<>();
	studentRecord.put("Anil", Arrays.asList(90,80,85,60));
	studentRecord.put("Mano", Arrays.asList(95,80,85,70));
	studentRecord.put("Subham", Arrays.asList(70,80,85,60));
	studentRecord.put("Abhishek", Arrays.asList(90,100,85,60));
	
    for (Map.Entry<String, List<Integer>> entry : studentRecord.entrySet()) {
        System.out.println(entry.getKey() + ": Max Mark : " +maxmark(entry.getValue()));
    }
		
	}
	
}

