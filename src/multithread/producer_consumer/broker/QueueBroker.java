package multithread.producer_consumer.broker;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueBroker {

	private final Queue<Integer> queue = new ConcurrentLinkedQueue<>();

	public void addToQueue(Integer value) {
		queue.offer(value);
	}

	public Integer peek() {
		return queue.peek();
	}

	public Integer poll() {
		return queue.poll();
	}

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
