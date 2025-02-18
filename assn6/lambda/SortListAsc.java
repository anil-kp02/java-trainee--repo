package com.assn6.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortListAsc {
	public static void main(String[] args) {
		
		Comparator<String> comp=((s1, s2) -> s1.length()-s2.length());
		List<String> words=Arrays.asList("Apple","Banana","DragonFruit","Kiwi","Mango");
		
		 words.sort(comp);
		 System.out.println(" Words length wise sort Manner is :"+words);
		
	}

}
