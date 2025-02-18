package com.assn4.list;

import java.util.ArrayList;
import java.util.List;

public class RemovePrimeNum {
public static void main(String[] args) {
	List<Integer> number=new ArrayList<>();
	number.add(5);
	number.add(13);
	number.add(321);
	number.add(124);
	number.add(25);
	number.add(10);
	number.add(21);
	number.add(7);
	 
	List<Integer> primeLess=new ArrayList<>();
	for(Integer num:number) {
		int counter=0;
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				counter++;
		}

	}
		if(counter==2) {
			continue;
		}else {
			primeLess.add(num);
		}
	}
	System.out.println("After Removeal of Prime Number :"+primeLess);
}
}
