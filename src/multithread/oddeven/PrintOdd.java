package multithread.oddeven;

public class PrintOdd implements Runnable {
	private final int capacity;
	private final Object object;

	PrintOdd(int capacity, Object object) {
		this.capacity = capacity;
		this.object = object;
	}

	@Override
	public void run() {
		while (Counter.getInstance().getCounter() <= capacity) {
			synchronized (object) {
				if (Counter.getInstance().getCounter() % 2 == 0) {
					try {
						System.out.println("Print odd waiting");
						object.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println(Thread.currentThread().getName() + " " + Counter.getInstance().getCounter());
					Counter.getInstance().increaseCounter();
					object.notifyAll();
				}
			}
		}
	}
}
