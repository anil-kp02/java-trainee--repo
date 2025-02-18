package com.assn4.map;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDepartment {
	public static Map<String, Integer> departmentINFO(Map<String, String> map){
		Map<String, Integer> result = new HashMap<>();
		
		for(Map.Entry<String, String> entry:map.entrySet()) {
			result.put(entry.getValue().toUpperCase(), result.getOrDefault(entry.getValue().toUpperCase(), 0)+1);
		}
		return result;
	}
public static void main(String[] args) {
	Map<String, String> map = new HashMap<>();
	map.put("Anil", "Java");
	map.put("Abhi", "Java");
	map.put("MAnoRanjan", "React");
	map.put("Bishnu", "React");
	map.put("Rohit", "Java");
	map.put("Satya", "QA");
	
	System.out.println("NUmber Of employee in Each department :"+departmentINFO(map));
}
}
