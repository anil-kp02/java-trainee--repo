package com.assn4.map;

import java.util.HashMap;
import java.util.Map;

public class MeaningSpecifiedPrefix {
	public static void prefix(Map<String, String> map, String specified_prefix) {
		for(Map.Entry<String, String> entry:map.entrySet()) {
			if(entry.getValue().toLowerCase().startsWith(specified_prefix.toLowerCase())) {
				System.out.println(entry.getKey());
			}
		}
	}
public static void main(String[] args) {
	Map<String, String> map=new HashMap<>();
	map.put("pelter", "a thrower of missiles");
	map.put(" concretize", "make something concrete");
	map.put("lubberly","clumsy and unskilled");
	map.put("paleobotany", "the study of fossil plants");
	map.put("Acarology", "The study of ticks and mites");
	
	String specified_prefix="The study of";
	
	System.out.println("The Words which Meaning Start with 'The Study of' prefix are ");
	prefix(map, specified_prefix);
	
}
}
