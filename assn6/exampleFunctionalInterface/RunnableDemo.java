package com.assn6.exampleFunctionalInterface;

public class RunnableDemo {
public static void main(String[] args) {
	Runnable r=()->{
		for(int i=0;i<5;i++) {
			System.out.println(" Person no :"+(i+1));
		}
	};
	Thread thread=new Thread(r);
	thread.start();
}
}
