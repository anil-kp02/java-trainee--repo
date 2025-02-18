package com.assn4.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequency {
	public static void frequency(List<String> words){
		//Map<Integer, String> result=new TreeMap<>();
		Map<String, Integer> result1=new TreeMap<>();
		
		for(String word:words) {
			result1.put(word,result1.getOrDefault(word,0)+1);
		}
		System.out.println(result1);
		for(Map.Entry<String,Integer> entry:result1.entrySet()) {
			System.out.println("Frequency :"+entry.getValue() +" Word :"+entry.getKey());
		}
		
		
		
	}
public static void main(String[] args) {
	List<String> words=new ArrayList<>(Arrays.asList("Apple","Mango","Kiwi","Apple","Banana"
			,"Mango","Apple","Apple"));
	frequency(words);
	
	
}
}
