package com.assn4.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacter {
	public static Set<Character> uniqueChar(String word){
		Set<Character> commonchar=new HashSet<>();
		Map<Character,Integer > frequency=new HashMap<>();
		
		for(char c:word.toCharArray()) {
			frequency.put(c,frequency.getOrDefault(c, 0)+1);
		}
		
		for(Character ch:frequency.keySet()) {
			if(frequency.get(ch)==1) {
				commonchar.add(ch);
			}
		}
		return commonchar;
	}
	
	public static Map<String, Set<Character>> result(Set<String> words){
		Map<String, Set<Character>> resultSet=new HashMap<>();
		for(String word:words) {
			resultSet.put(word, uniqueChar(word));
		}
		return resultSet;
	}

public static void main(String[] args) {
	Set<String> words=new HashSet<>();
	words.add("Apple");
	words.add("Orange");
	words.add("kiwi");
	words.add("Dragon Fruit");
	words.add("Naspati");
	words.add("Apple");
	
	System.out.println(result(words));
	
	
	
}
}
