package com.assn4.list;

import java.util.ArrayList;
import java.util.List;

public class LongestWord {
public static void main(String[] args) {
	List<String> words=new ArrayList<>();
	words.add("Apple");
	words.add("Orange");
	words.add("kiwi");
	words.add("Dragon Fruit");
	words.add("Naspati");
	words.add("Apple");
	
	words.sort((s1,s2)->Integer.compare(s1.length(), s2.length()));
	
	System.out.println("Longest Word is :"+words.get((words.size()-1)));
}
}
