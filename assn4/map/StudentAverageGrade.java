package com.assn4.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentAverageGrade {
	public static Double calculateAvergae(List<Integer>record) {
		Double average=0.0;
		int count=0;
		for(Integer value:record) {
			average+=value;
			count++;
		}
		average/=count;
		
		return average;
		
	}
	public static String averageGrade(Double average) {
		String result=null;
		if(average>=90) {
			result="A+";
		}
		else if (average>=80 && average<90) {
			result="A";
		}
		else if (average>=70 && average<80) {
			result="B+";
			
		}
		else if(average>=60 && average<70) {
			result="B";
		}
		else {
			result="F";
		}
		return result;
	}
public static void main(String[] args) {
	Map<String,List<Integer>> studentRecord=new HashMap<>();
	studentRecord.put("Anil", Arrays.asList(90,80,85,60));
	studentRecord.put("Mano", Arrays.asList(95,80,85,70));
	studentRecord.put("Subham", Arrays.asList(70,80,85,60));
	studentRecord.put("Abhishek", Arrays.asList(90,100,85,60));
	
	for (Map.Entry<String, List<Integer>> entry : studentRecord.entrySet()) {
        System.out.println(entry.getKey() + ": Average Mark : " 
	+averageGrade(calculateAvergae(entry.getValue())));
    }
}
}
