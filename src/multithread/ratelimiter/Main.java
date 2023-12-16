package multithread.ratelimiter;

public class Main {
	public static void main(String[] args) {
		int capacity = 5;
		long allowedDuration = 5;
		RateLimiterService service = new RateLimiterService(capacity, allowedDuration);
		APIClient client = new APIClient("user1", service);
		APIClient client1 = new APIClient("user2", service);

		Thread t1 = new Thread(client, "user1");
		Thread t2 = new Thread(client1, "user2");

		t1.start();
		t2.start();

	}
}
