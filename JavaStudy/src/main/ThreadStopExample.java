package main;

import java.util.concurrent.TimeUnit;

public class ThreadStopExample {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * We have a Counter class that counts from zero to 100 milion. Each
		 * time the loop iterates we call the method isInterrupted() (inherited
		 * from the Thread class). This method returns true if the interrupted
		 * flag has been set and false if not. If the thread has been
		 * interrupted we return from the run() method. Otherwise, we do the
		 * action as planned and print the number.
		 */

		Counter counter = new Counter();
		counter.start();

		/* Wait one second */
		TimeUnit.SECONDS.sleep(1);

		System.out.println("Stopping the counter...");
		counter.interrupt();

	}

	public static class Counter extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 100000000; i++) {
				if (isInterrupted()) {
					System.out.println("Thread has been interrupted.");
					return;
				}
				System.out.println(i);
			}
		}
	}

}
