package com.assn3.methodsInThraed;

class Demo{
	int flag=10;
	public void waitDemo(int key){
		if(flag<key) {
			try {
				System.out.println("Wait method Invoked");
				wait();
			}catch(Exception e) {
				
			}
		}else {
			flag-=key;
			System.out.println("Transaction sucessfully submited");
		}
		
	}
	public void notifyDemo(int key) {
		flag+=key;
		System.out.println("Notify Invoked");
		notify();
		notifyAll();
	}
}
public class RemainingMethods {
	public static void main(String[] args) {
		Demo obj=new Demo();
		Thread thread1=new Thread() {
			public void run() {
				obj.waitDemo(15);
			}
		};
		thread1.start();
		Thread thread2=new Thread() {
			public void run() {
				obj.notifyDemo(15);
			}
		};
		thread2.start();
		
	}
	

}
