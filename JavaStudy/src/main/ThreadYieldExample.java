package main;

public class ThreadYieldExample {
	public static void main(String[] args)    {
		Thread producer = new ProducerTest();
		Thread consumer = new ConsumerTest();
		producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
		consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority
		producer.start();
		consumer.start();
		}
	
	static class ProducerTest extends Thread {
		public void run() {
			for (int i = 0; i < 5; i++){
				System.out.println("I am Producer : Produced Item " + i);
				Thread.yield();
				}
			}
	}
	
	static class ConsumerTest extends Thread {
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("I am Consumer : Consumed Item " + i);
				Thread.yield();
				}
			}
	}
}
