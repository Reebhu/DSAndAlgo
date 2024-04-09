package machinecoding.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LFUCache {

	Map<Integer, Data> map;
	Map<Integer, Queue<Integer>> counterMap;
	int capacity;
	int min = 0;

	public LFUCache(int capacity) {
		map = new HashMap<>();
		counterMap = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Data value = map.get(key);
		int count = value.getCount();
		min = Math.min(min, count + 1);
		Queue prevQueue = counterMap.get(count);
		prevQueue.remove(key);
		value.setCount(count + 1);
		Queue queue = counterMap.get(value.getCount());
		if (queue == null)
			queue = new LinkedList();
		queue.offer(key);
		map.put(key, value);
		counterMap.put(value.getCount(), queue);
		return value.getValue();
	}

	public void put(int key, int value) {
		Data data = map.get(key);
		if (data != null) {
			data.setValue(value);
		}
		else {
			data = new Data(value, 1);
		}
		int count = data.getCount();
		min = Math.min(count, min);
		Queue prevQueue = counterMap.get(count);
		prevQueue.remove(key);
		data.setCount(count + 1);
		Queue queue = counterMap.get(data.getCount());
		if (queue == null)
			queue = new LinkedList();
		queue.offer(key);
		map.put(key, data);
		counterMap.put(data.getCount(), queue);

		if (map.size() > capacity) {
			counterMap.get(min).poll();
		}
	}
}
