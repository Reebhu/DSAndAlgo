package multithread.oddeven;

public class Counter {

	private int n = 0;

	private static Counter INSTANCE;

	private Counter() {
	}

	public static Counter getInstance() {
		if (INSTANCE == null) {
			synchronized (Counter.class) {
				if (INSTANCE == null) {
					return INSTANCE = new Counter();
				}
			}
		}
		return INSTANCE;
	}

	public int getCounter() {
		return n;
	}

	public int increaseCounter() {
		return n = n + 1;
	}
}
