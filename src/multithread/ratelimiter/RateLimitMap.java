package multithread.ratelimiter;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitMap {

	private final Map<String, LinkedList<Integer>> rateMap = new ConcurrentHashMap<>();
	private static RateLimitMap INSTANCE;

	private RateLimitMap() {
	}

	public static RateLimitMap getInstance() {
		if (INSTANCE == null) {
			synchronized (RateLimitMap.class) {
				if (INSTANCE == null) {
					return INSTANCE = new RateLimitMap();
				}
			}
		}
		return INSTANCE;
	}

	public Map<String, LinkedList<Integer>> getRateMap() {
		return rateMap;
	}
}
