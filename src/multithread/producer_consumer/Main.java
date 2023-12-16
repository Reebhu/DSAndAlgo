package multithread.producer_consumer;

import multithread.producer_consumer.broker.QueueBroker;

public class Main {
	public static void main(String[] args) {
		QueueBroker broker = new QueueBroker();
		Producer producer = new Producer(broker, 10);
		Consumer consumer = new Consumer(broker);
		Consumer consumer2 = new Consumer(broker);

		Subscriber subscriber = new Subscriber(broker);

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		Thread t3 = new Thread(consumer2);
		Thread t4 = new Thread(subscriber);
		t1.setName("Producer");
		t2.setName("Consumer1");
		t3.setName("Consumer2");
		t4.setName("Subscriber");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
