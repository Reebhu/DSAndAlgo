package machinecoding.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

	Queue<Integer> queue;
	Map<Integer, Integer> map;
	int capacity;

	public LRUCache(int capacity) {
		queue = new LinkedList<>();
		map = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer value = map.getOrDefault(key, -1);
		queue.remove(key);
		queue.offer(key);
		return value;
	}

	public void put(int key, int value) {
		map.put(key, value);
		queue.remove(key);
		queue.offer(key);
		if (map.size() > capacity) {
			int evictedKey = queue.poll();
			map.remove(evictedKey);
		}
	}

}
