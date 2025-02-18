package com.assn4.list;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameFrequency {
	public static void main(String[] args) {
		List<String> names=new ArrayList<>();
		names.add("Anil");
		names.add("Satya");
		names.add("Gacha");
		names.add("Anil");
		names.add("Subham");
		names.add("Anil");
		names.add("Abhi");
		
		System.out.println("Before Frequency calculation"+names);
		Map<String,Integer> unique=new HashMap<>();
		 for (String name : names) {
			unique.put(name,unique.getOrDefault(name, 0)+1) ;
		}
		 System.out.println(unique);
	}

}
