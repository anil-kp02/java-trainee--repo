package com.assn3.creationOfThread;

public class CreateThreadUsingThreadClass extends Thread{
	public void run() {
		System.out.println("Thread Is Sucessfully created using Thraed Class");
	}
	public static void main(String[] args) {
		CreateThreadUsingThreadClass thread=new CreateThreadUsingThreadClass();
		thread.start();
		
	}

}
