package com.assn2.string;

class ToStringDemo{
	 
	String name;
	String company;
	int id;
	
	ToStringDemo(String name,String company,int id){
		this.name=name;
		this.company=company;
		this.id=id;
		
		
	}
	//@override
	public String toString() {
		return "Employee Details[ NAme :"+name +  "Company :"+company +  "Empid :"+id+"]";
	}
}

public class StringDemo {
	public static void main(String args[]) {
		
		//String Object Initialization
		String s ="Anil kumar Pradhan";
		System.out.println(s);
		StringBuffer sb= new StringBuffer("Abinash");
		System.out.println(sb);
		StringBuilder sb2=new StringBuilder("Manoranjan");
		System.out.println(sb2);
		String s2=new String();
		s2="    No Argument Constructor     ";
		System.out.println(s2);
		
		byte[] b= {100,102,103};
		String s3 = new String(b); //Taking argument as byte array
		System.out.println(s3);
		
		char[] c= {'a','n','i','l'};
		String s4= new String(c);
		System.out.println(s4);     //Taking Argument as char array
		
		
		// Methods in string
		System.out.println(String.join(",",s4,s2,s3));
		System.out.println(s2.trim());
		System.out.println(s.equals(s4));
		System.out.println(s.substring(4));
		System.out.println(s.replace("Anil","ANIL"));
		System.out.println(s.indexOf("A"));
		System.out.println(s.charAt(2));
		System.out.println(s.contains(s4));
		System.out.println(s.contains("ku"));
		System.out.println(s.startsWith("a"));
		System.out.println(s.toLowerCase());
		
		
		// To string method override
					
		ToStringDemo emp= new ToStringDemo("Anil","RApidSoft",060);
		System.out.println(emp); //it will print the class name and  a hash cod value before override
		System.out.println(emp.toString());
		
		
	}

}
