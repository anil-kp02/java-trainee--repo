package com.assn1.calculation;

public class Area {
	public static double calculateArea(Double radius,Double bredth) {
		if(bredth == null) {
			return Math.PI*radius*radius;
		}
		else {
			return radius*bredth;
		}
	}

}
