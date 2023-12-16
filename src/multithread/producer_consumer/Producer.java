package multithread.producer_consumer;

import multithread.producer_consumer.broker.QueueBroker;

public class Producer implements Runnable {

	QueueBroker broker;
	int capacity;

	public Producer(QueueBroker broker, int capacity) {
		this.broker = broker;
		this.capacity = capacity;
	}

	@Override
	public void run() {
		int i = 0;
		synchronized (broker) {
			while (true) {
				if (broker.size() == capacity) {
					try {
						System.out.println(Thread.currentThread().getName() + " is waiting");
						broker.wait();

					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Added to queue " + i);
					broker.addToQueue(i++);
					broker.notifyAll();
				}
			}
		}
	}
}
