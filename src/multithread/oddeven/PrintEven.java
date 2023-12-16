package multithread.oddeven;

public class PrintEven implements Runnable {
	private final int capacity;
	private final Object obj;

	PrintEven(int capacity, Object obj) {
		this.capacity = capacity;
		this.obj = obj;
	}

	@Override
	public void run() {
		while (Counter.getInstance().getCounter() <= capacity) {
			synchronized (obj) {
				if (Counter.getInstance().getCounter() % 2 != 0) {
					try {
						System.out.println("Print even waiting");
						obj.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println(Thread.currentThread().getName() + " " + Counter.getInstance().getCounter());
					Counter.getInstance().increaseCounter();
					obj.notifyAll();
				}
			}
		}
	}
}
