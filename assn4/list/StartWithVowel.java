package com.assn4.list;

import java.util.ArrayList;
import java.util.List;

public class StartWithVowel {
	public static void main(String[] args) {
		List<String> name=new ArrayList<>();
		name.add("Anil");
		name.add("Biswa");
		name.add("Satya");
		name.add("Mano");
		name.add("Subha");
		name.add("Esha");
		
		List<String> modified=new ArrayList<>();
		
		for(String n:name) {
			if(n.startsWith("A")||n.startsWith("E")||n.startsWith("I")||n.startsWith("O")||n.startsWith("U")) {
				continue;
			}
			else {
				modified.add(n);
			}
			
		}
		System.out.println("After Vowel intiate word elimination :"+modified);
	}

}
