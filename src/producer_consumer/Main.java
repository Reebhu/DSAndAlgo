package producer_consumer;

import producer_consumer.broker.QueueBroker;

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
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();

		System.out.println("🏥 *Saudi German Health - UAE* 🌟\r\n\r\nHello New Test!\r\n\r\n🙏🏻 Thank you for using our services at Saudi German Health - UAE. 🙏🏻\r\n\r\n*How likely are you to " +
				"recommend our services to your family and friends?*\r\nYou can respond by replying with the number 0 to 10.\r\n\r\n0 -\u003e 😒 Not at all likely\r\n1-3 -\u003e 😑 Somewhat " +
				"unlikely\r\n4-6 -\u003e 😐 Neutral\r\n7-8 -\u003e 😄 Somewhat likely\r\n9-10 -\u003e 😍 Extremely likely\r\n\r\n🙏🏻 شكرا لك على استخدام خدماتنا في المستشفى السعودي الألماني " +
				"الإمارات العربية المتحدة 🙏🏻\r\n\r\n*ما مدى احتمالية أن توصي بخدماتنا لعائلتك وأصدقائك؟*\r\nيمكنك الرد بالرد بالرقم من 0 إلى 10\r\n\r\n0 -\u003e 😒 غير محتمل على الإطلاق\r\n1-3 " +
				"-\u003e 😑 غير محتمل إلى حد ما\r\n4-6 -\u003e 😐 حيادي\r\n7-8 -\u003e 😄 محتمل بشكل ما\r\n9-10 -\u003e 😍 من المرجح للغاية\r\n\r\nTo stop receiving notifications on WhatsApp in the " +
				"future, reply with *STOP*");

	}
}
