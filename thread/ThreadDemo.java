package thread;

public class ThreadDemo implements Runnable{
	public void run() {
		System.out.println("Thread is running");
	}
	
	public static void main(String args[]) {
		ThreadDemo th1= new ThreadDemo();
		Thread t = new Thread(th1,"My first thread");
		t.start();
		String nm=t.getName();
		System.out.println(nm);
		
		
	}

}
