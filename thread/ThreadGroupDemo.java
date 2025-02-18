package thread;

public class ThreadGroupDemo implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String args[]) {
		ThreadGroupDemo runnable= new ThreadGroupDemo();
		ThreadGroup thg = new ThreadGroup("parent thread Group");
		Thread th1=new Thread(thg,runnable,"one");
		Thread th2=new Thread(thg,runnable,"two");
		Thread th3=new Thread(thg,runnable,"three");
		
		th1.start();
		th2.start();
		th3.start();
		
		
		
	}

}
