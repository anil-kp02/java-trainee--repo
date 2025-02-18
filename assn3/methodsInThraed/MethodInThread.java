package com.assn3.methodsInThraed;

public class MethodInThread implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}
	public static void main(String[] args) {
		MethodInThread obj=new MethodInThread();
		Thread thread1=new Thread(obj);
		Thread thread2=new Thread(obj);
		thread1.start();
		System.out.println("Id of the Thread"+Thread.currentThread().getId());
		System.out.println("Name of the Thread "+Thread.currentThread().getName());
		System.out.println("Priority of the Thread "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(7);
		System.out.println("Priority  of the Thread after Modification"+Thread.currentThread().getPriority());
		thread2.start();
		System.out.println("Id of the 2nd Thread"+Thread.currentThread().getId());
		System.out.println("Name of the 2nd Thread "+Thread.currentThread().getName());
		System.out.println("Priority of2nd the Thread "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(10);
		System.out.println("Priority  of the Thread after Modification"+Thread.currentThread().getPriority());
	}

}
