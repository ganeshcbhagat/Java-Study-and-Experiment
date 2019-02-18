package main;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample1 {

	public static void main(String[] args) {

		final int numPhases = 3;

		Phaser phaser = new Phaser(3) {
			// Override onAdvance() to execute the specified number of phases.
			protected boolean onAdvance(int p, int regParties) {
				System.out.println("Registered Parties:" + regParties + " : Phase " + p + " completed.\n");
				// If all phases have completed, return true
				if (p == numPhases || regParties == 0)
					return true;
				// Otherwise, return false.
				return false;
			}
		};
		
		Bus f1 = new Bus(phaser, "Bus 1");
		Bus f2 = new Bus(phaser, "Bus 2");
		Bus f3 = new Bus(phaser, "Bus 3");
		f1.start();
		f2.start();
		f3.start();

	}

	public static class Bus extends Thread {

		private Phaser phaser;
		private Random random;

		public Bus(Phaser phaser, String name) {
			this.phaser = phaser;
			setName(name);
			random = new Random();
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is ready.");
			phaser.arriveAndAwaitAdvance(); // waiting for all busses to be ready
			goToNewYork();
			goToNewJersey();
			goToWashington();
			//phaser.arriveAndDeregister();
		}

		private void goToNewYork() {
			System.out.println(Thread.currentThread().getName() + " going to New York...");
			int sleep = random.nextInt(5);
			try {
				TimeUnit.SECONDS.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " arrived in New York.");
			phaser.arriveAndAwaitAdvance();
		}

		private void goToNewJersey() {
			System.out.println(Thread.currentThread().getName() + " going to New Jersey...");
			int sleep = random.nextInt(10);
			try {
				TimeUnit.SECONDS.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " arrived in New Jersey.");
			phaser.arriveAndAwaitAdvance();
		}

		private void goToWashington() {
			System.out.println((Thread.currentThread().getName() + " going to Washington..."));
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName() + " arrived in Washington");
		}
	}

}
