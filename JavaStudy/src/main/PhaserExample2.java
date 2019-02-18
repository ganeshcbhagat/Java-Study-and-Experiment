package main;

import java.util.concurrent.Phaser;

public class PhaserExample2 {

	public static void main(String[] args) {
		final int numPhases=4;
		Phaser phsr = new Phaser(1) {
			// Override onAdvance() to execute the specified number of phases.
			protected boolean onAdvance(int p, int regParties) {
				System.out.println("Registered Parties:"+regParties+" : Phase " + p + " completed.\n");
				
				// If all phases have completed, return true
				if(p == numPhases || regParties == 0) return true;
				
				// Otherwise, return false.
				return false;
			}
		};
		
		System.out.println("Starting");
		new MyThread(phsr, "A");
		new MyThread(phsr, "B");
		new MyThread(phsr, "C");
		
		// Deregister the main thread.
		phsr.arriveAndDeregister();
		
		if(phsr.isTerminated())
		System.out.println("The Phaser is terminated");
		
	}
	
	private static class MyThread implements Runnable {
		Phaser phsr;
		String name;
		
		public MyThread(Phaser p, String n) {
			phsr = p;
			name = n;
			phsr.register();
			new Thread(this).start();
		}
		
		public void run() {
			System.out.println("Thread " + name + " Beginning Phase One");
			phsr.arriveAndAwaitAdvance(); // Signal arrival.
			// Pause a bit to prevent jumbled output. This is for illustration only. It is not required for the proper operation of the phaser.
			try {
				Thread.sleep(800);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
			
			System.out.println("Thread " + name + " Beginning Phase Two");
			phsr.arriveAndAwaitAdvance(); // Signal arrival.
			// Pause a bit to prevent jumbled output. This is for illustration only. It is not required for the proper operation of the phaser.
			try {
				Thread.sleep(800);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
			
			System.out.println("Thread " + name + " Beginning Phase Three");
			phsr.arriveAndDeregister(); // Signal arrival and deregister.
		}
	}
	
}
