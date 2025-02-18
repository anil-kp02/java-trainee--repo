package com.assn4.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderWRTToLength {
public static void main(String[] args) {
	List<String> words=new ArrayList<>();
	words.add("Apple");
	words.add("Orange");
	words.add("kiwi");
	words.add("Dragon Fruit");
	words.add("Naspati");
	words.add("Apple");
	
//	Map<String, Integer > wordLength=new HashMap<>();
//	for(String word:words) {
//		wordLength.put(word, word.length());
//	}
//	
//	List<Integer> length=new ArrayList<>(); 
//	length.addAll(wordLength.values());
//	length.sort(null);
//	
//	for(int index=0;index<length.size();index++) {
//		if(wordLength.containsValue(length.get(index))) {
//			wordLength.
//		}
//		
//	}
	
	words.sort((s1,s2)->Integer.compare(s1.length(), s2.length()));
	System.out.println(words);
	
}
}
