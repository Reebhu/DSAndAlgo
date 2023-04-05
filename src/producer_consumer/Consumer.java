package producer_consumer;

import producer_consumer.broker.QueueBroker;

public class Consumer implements Runnable {
	QueueBroker broker;

	public Consumer(QueueBroker broker) {
		this.broker = broker;
	}

	@Override
	public void run() {

		synchronized (broker) {
			while (true) {
				if (broker.isEmpty()) {
					try {
						System.out.println(Thread.currentThread().getName() + " is waiting");
						broker.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println(Thread.currentThread().getName() + " " + broker.poll());
					broker.notifyAll();
				}
			}
		}
	}
}
