package multithread.ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService {

	private final int capacity;
	private final Map<String, LinkedList<Instant>> rateMap = new ConcurrentHashMap<>();
	private final Long allowedDifference;

	public RateLimiterService(int capacity, Long allowedDifference) {
		this.capacity = capacity;
		this.allowedDifference = allowedDifference;
	}

	public boolean hit(String userId, Instant timestamp) {
		if (!rateMap.containsKey(userId)) {
			rateMap.put(userId, new LinkedList<>(List.of(timestamp)));
			return true;
		}

		LinkedList<Instant> earlierTimestamps = rateMap.get(userId);

		while (!earlierTimestamps.isEmpty()) {
			if (Duration.between(earlierTimestamps.peek(), Instant.now()).abs().getSeconds() >= allowedDifference)
				earlierTimestamps.poll();
			break;
		}

		if (earlierTimestamps.size() < capacity) {
			earlierTimestamps.add(timestamp);
			rateMap.put(userId, earlierTimestamps);
			return true;
		}

		System.out.println("call blocked");
		return false;
	}
}
