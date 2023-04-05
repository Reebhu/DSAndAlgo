package producer_consumer;

import producer_consumer.broker.QueueBroker;

public class Subscriber implements Runnable {
	QueueBroker broker;

	public Subscriber(QueueBroker broker) {
		this.broker = broker;
	}

	@Override
	public void run() {
		while (true) {
			if (broker.isEmpty()) {
				return;
			}
			System.out.println(broker.peek());
		}
	}
}
