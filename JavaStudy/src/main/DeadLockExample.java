package main;

public class DeadLockExample {

	public static void main(String[] args) throws Exception {
		System.out.println("Start");
		String resource1 = "Ganesh";
		String resource2 = "Rajesh";

		// t1 tries to lock resource1 then resource2
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource2) {
						System.out.println("Thread 2: locked resource 2");
					} // Enf of synchronized (resource2)

				} // Enf of synchronized (resource1)
			}
		};

		// t2 tries to lock resource2 then resource1
		Thread t2 = new Thread() {
			public void run() {

				// Dead Lock situation
				synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource1) {
						System.out.println("Thread 1: locked resource 1");
					} // Enf of synchronized (resource1)

				} // Enf of synchronized (resource2)

				// to solve the deadlock un comment below and comment above
				// synchronized
				/*
				 * synchronized (resource1) { System.out.println(
				 * "Thread 1: locked resource 1");
				 * 
				 * try { Thread.sleep(100);} catch (Exception e) {}
				 * 
				 * synchronized (resource2) { System.out.println(
				 * "Thread 2: locked resource 2"); }// Enf of synchronized
				 * (resource2)
				 * 
				 * }// Enf of synchronized (resource1)
				 */
			}
		};

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("End"); // 33551 , 31246
	}
}
