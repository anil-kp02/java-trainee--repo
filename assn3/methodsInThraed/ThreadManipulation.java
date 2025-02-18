package com.assn3.methodsInThraed;

public class ThreadManipulation implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Currentley executing Thread"+Thread.currentThread().getName()+" :"+i);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) {
		ThreadManipulation obj=new ThreadManipulation();
		Thread thread1 =new Thread(obj);
		Thread thread2 =new Thread(obj);
		Thread thread3 =new Thread(obj);
		Thread thread4 =new Thread(obj);
		
		thread1.setPriority(1);
		thread2.setPriority(2);
		thread3.setPriority(3);
		
		thread1.start();
		thread2.start();
		thread1.interrupt();
		
		try {
			thread2.join();
		}catch(Exception e) {
			System.out.println(e);
		}
		thread3.start();
		Thread.yield();
		thread4.start();
		
	}

}
