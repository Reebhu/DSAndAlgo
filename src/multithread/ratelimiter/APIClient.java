package multithread.ratelimiter;

import java.time.Instant;

public class APIClient implements Runnable {
	private final RateLimiterService rateLimit;
	private final String user;

	public APIClient(String user, RateLimiterService rateLimitService) {
		this.user = user;
		this.rateLimit = rateLimitService;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 65; i++) {
			System.out.println("Thread Name - " + getName() + ", Time - " + i + ", rate limit: " + hit(getName(), Instant.now()));
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DONE! " + getName());
	}

	public boolean hit(String user, Instant ts) {
		return rateLimit.hit(user, ts);
	}

	private String getName() {
		return user;
	}
}
