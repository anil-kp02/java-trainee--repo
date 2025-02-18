package com.assn4.map;

import java.util.HashMap;
import java.util.Map;

public class ProductInvoice {
	public static double total() {
		return 0;
	}
	public static void main(String[] args) {
		Map<String, Double> map=new HashMap<>();
		map.put("Apple", 80000.0);
		map.put("Samsung", 100000.0);
		map.put("OnePlus ", 60000.0);
		map.put("Google pixel", 68000.0);
		map.put("Noting", 43000.0);
		System.out.println("   PRODUCT NAME        PRICE  ");
		System.out.println("_______________________________");
		
		for(Map.Entry<String, Double> entry:map.entrySet()) {
			System.out.println("   "+entry.getKey() +"        "+entry.getValue() );
			
		}
		double total=0;
		for(Double price:map.values()) {
			total+=price;
			
		}
		System.out.println("- - - - - - - - - - - - - - - -");
		System.out.println("  TOTAL :   "+total);
		
	}

}
