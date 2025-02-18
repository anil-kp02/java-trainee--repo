package thread;

public class CallRunDemo extends Thread{	
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
		CallRunDemo t1= new CallRunDemo();
		CallRunDemo t2= new CallRunDemo();
		
		t1.run();
		t2.run();
		
	}

}

