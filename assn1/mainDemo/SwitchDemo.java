package com.assn1.mainDemo;

import java.util.Scanner;
import com.assn1.calculation.*;
import com.assn1.classes.*;

public class SwitchDemo {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Shape obj=new Shape();
		do {
		System.out.println("Chose Which Operation you want to Perform \n For Area of Circle Press 1 \n For Perimeter of circle Press 2 \n For Area of Rectangle Press 3 \n For Perimeter of Rectangle Press 4 \n To Close the Calculation Press 0");
		int choice=sc.nextInt();
		
		switch (choice) {
		case 0: System.exit(0);
			
		case 1:	System.out.println("Enter The Radius of circle ");
		 obj.setRadius(sc.nextDouble());
		 obj.setBredth(null);
		 System.out.println("Area of the circle is : " + Area.calculateArea(obj.getRadius(), obj.getBredth()));
		 break;
		case 2: System.out.println("Enter The Radius of circle ");
		 obj.setRadius(sc.nextDouble());
		 obj.setBredth(null);
		 System.out.println("Perimeter of the circle is : " + Perimeter.calculatePerimeter(obj.getRadius(), obj.getBredth()));
		 break;
		case 3:System.out.println("Enter The Length of the Rectangle ");
		obj.setRadius(sc.nextDouble());

		System.out.println("Enter the bredth of a Rectangle :");
		obj.setBredth(sc.nextDouble());
		System.out.println("Area of the Rectangle is : " + Area.calculateArea(obj.getRadius(), obj.getBredth()));
		break;
		
		case 4:System.out.println("Enter The Length of the Rectangle ");
		obj.setRadius(sc.nextDouble());

		System.out.println("Enter the bredth of a Rectangle :");
		obj.setBredth(sc.nextDouble());
		System.out.println("Perimeter of the Rectangle is : " + Perimeter.calculatePerimeter(obj.getRadius(), obj.getBredth()));
		break;
		
		default: System.out.println("Please Enter a valid Choice ");
			break;
		}
		
	}while(true);
	}

}
