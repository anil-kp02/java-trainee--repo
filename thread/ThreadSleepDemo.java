package thread;

public class ThreadSleepDemo extends Thread{	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(Exception exp) {
				System.out.println(exp);
			}
		}
			

	}
	public static void main(String args[]) {
		ThreadSleepDemo t1= new ThreadSleepDemo();
		ThreadSleepDemo t2= new ThreadSleepDemo();
		
		t1.start();
		t2.start();
		
	}

}

