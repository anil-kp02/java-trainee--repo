package thread;

class Customer{
	int amount = 10000;
	
	public void widraw(int amount) {
		if(this.amount < amount) {
			System.out.println("Less Amount");
			try {
				wait();
			}catch(Exception e){
				
			}
			this.amount-=amount;
			System.out.println("Widraw Complete ...");
		}
	}
	
	public void deposit(int amount) {
		System.out.println("Dpositing .....");
		this.amount+=amount;
		System.out.println("Deposit Complete . .  . . ");
		notify();
	}
}

public class WaitMethodDemo {
	public static void main(String args []) {
		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.widraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
			
		}.start();
		
	}

}
