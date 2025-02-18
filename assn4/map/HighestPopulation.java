package com.assn4.map;

import java.util.HashMap;
import java.util.Map;

public class HighestPopulation {
	public static Map<String,Integer> maxPopulation(Map<String, Integer> population){
		Map<String, Integer> result=new HashMap<>();
		int maxpopulation=Integer.MIN_VALUE;
		for(Map.Entry<String, Integer> entry:population.entrySet()) {
			if(entry.getValue()>maxpopulation) {
				maxpopulation=entry.getValue();
			}
		}
		//put result in the map
		for(Map.Entry<String, Integer> entry:population.entrySet()) {
			if(entry.getValue().equals(maxpopulation)) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
public static void main(String[] args) {
	Map<String, Integer> population=new HashMap<>();
	population.put("Puri", 28194);
	population.put("Bhubaneswar", 217372);
	population.put("Baleswar", 213425);
	population.put("Koraput", 32132);
	population.put("KendraPada", 21343);
	population.put("Cuttack", 34212);
	
	System.out.println(" The city Having max population is :"+maxPopulation(population));
}
}
