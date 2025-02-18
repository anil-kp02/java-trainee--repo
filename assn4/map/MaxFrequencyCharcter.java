package com.assn4.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaxFrequencyCharcter {
	
	public static int maxFrequency(Collection<Integer> collection) {
		int max_frequecy=Integer.MIN_VALUE;
		for(Integer value:collection) {
			if(value>max_frequecy) {
				max_frequecy=value;
			}
		}
		return max_frequecy;
	}
	
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println(" Enter A String :");
	String string=sc.nextLine();
	
	Map<Character, Integer> frequency=new HashMap<>();
	for(Character character:string.trim().toCharArray()) {
		frequency.put(character, frequency.getOrDefault(character, 0)+1);
	}
	int max_frequency = maxFrequency(frequency.values());
	System.out.println(" MAXIMUM FREQUENCY");
	for(Map.Entry<Character, Integer> entry:frequency.entrySet()){
		if(entry.getValue()==max_frequency) {
			System.out.println("The Charcter :"+entry.getKey()+ "  Having frequency : "+entry.getValue());
		}
	}
}
}
