package thread;

class TableM {
	synchronized void printTable(int n) {
		for(int i=1;i<5;i++) {
			System.out.println(n*i);
			try {
				Thread.sleep(500);
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}

public class SynchronisationDemo2 {
	public static void main(String args[]) {
	final TableM obj=new TableM();
	
	Thread t1 =new Thread() {
		public void run() {
			obj.printTable(100);
		}
	};
	Thread t2 = new Thread() {
		public void run() {
			obj.printTable(10);
		}
	};
	
	t1.start();
	t2.start();

}
}
