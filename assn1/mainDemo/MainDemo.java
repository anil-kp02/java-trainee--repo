package com.assn1.mainDemo;

import java.util.Scanner;
import com.assn1.calculation.*;
import com.assn1.classes.*;

public class MainDemo {
	public static void main(String args[]) {
		
		Shape obj=new Shape();
		Scanner sc=new Scanner(System.in);
		int flag=1;
		
		while(flag==1) {
			System.out.println("Enter The Radius of circle / Length if Rectangle ");
			obj.setRadius(sc.nextDouble());

			System.out.println("Enter the bredth of a Rectangle ,if not Press '0' :");
			obj.setBredth(sc.nextDouble());
			if(obj.getBredth()==0) {
				obj.setBredth(null);
			}

			if (obj.getBredth() == null) {
				System.out.println("Area of the circle is : " + Area.calculateArea(obj.getRadius(), obj.getBredth()));
				System.out.println("perimeter of the Circle is :"
						+ Perimeter.calculatePerimeter(obj.getRadius(), obj.getBredth()));
			} else {
				System.out
						.println("Area of the Rectangle is : " + Area.calculateArea(obj.getRadius(), obj.getBredth()));
				System.out.println("perimeter of the Rectangle is :"
						+ Perimeter.calculatePerimeter(obj.getRadius(), obj.getBredth()));
			}
			System.out.println("Do you want to recalculate if yes \n press 1 \n if No press 0");
			flag=sc.nextInt();
		}
	}

}
