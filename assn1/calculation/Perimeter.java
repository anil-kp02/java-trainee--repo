package com.assn1.calculation;

public class Perimeter {
	public static double calculatePerimeter(Double radius ,Double bredth) {
		if(bredth==null) {
			return 2*3.14*radius;
		}
		else {
			return 2*(radius+bredth);
		}
	}

}
