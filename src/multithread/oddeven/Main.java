package multithread.oddeven;

public class Main {
	public static void main(String[] args) {

		int capacity = 20;
		Object obj = new Object();
		PrintEven printEven = new PrintEven(capacity, obj);
		PrintOdd printOdd = new PrintOdd(capacity, obj);

		Thread t1 = new Thread(printEven);
		Thread t2 = new Thread(printOdd);

		t1.start();
		t2.start();
	}
}
