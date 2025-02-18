package com.assn3.creationOfThread;

public class CreatethreadUsingInterface implements Runnable {
	public void run() {
		System.out.println("Thread Is Sucessfully created using unnable Interface");
	}
	public static void main(String[] args) {
		CreatethreadUsingInterface obj=new CreatethreadUsingInterface();
		Thread thread1=new Thread(obj);
		thread1.start();
		
		
	}

}
