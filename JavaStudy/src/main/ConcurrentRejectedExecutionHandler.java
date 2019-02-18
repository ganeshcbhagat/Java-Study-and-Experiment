package main;

import java.util.concurrent.ThreadFactory;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrentRejectedExecutionHandler {
	// Thread pool with the rejected executor handler configured
	public static ThreadPoolExecutor threadP = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

	// Threads which will block on the runnable queue.
	public static ThreadPoolExecutor threadR = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

	// Queue for storing the runnable instances which cannot be executed by threadP
	public static Queue<Runnable> runnable_queue = new LinkedBlockingQueue<Runnable>();

	public static void main(String[] args) throws InterruptedException {
		threadR.setThreadFactory(new CustomThreadFactory());
		threadP.setRejectedExecutionHandler(new RejectedHandler());

		// pre start all core threads..
		threadR.prestartAllCoreThreads();

		threadP.submit(new WorkerThread("Runnable executed by the thread pool executor.."));
		Thread.sleep(450);
		// shutdown..
		threadP.shutdownNow();
		// Now the rejected tasks handler comes into the picture..
		threadP.submit(new WorkerThread("Runnable which got rejected-1.."));
		threadP.submit(new WorkerThread("Runnable which got rejected-2.."));
		threadP.submit(new WorkerThread("Runnable which got rejected-3.."));

		// shut down the deferred thread pool:
		threadR.shutdown();

		boolean done = false;
		try {
			done = threadR.awaitTermination(1, TimeUnit.MINUTES);
				   threadP.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(done) {
			System.out.println("Program End");
		} else {
			System.out.println("Program is still running");
		}
	}
}

class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable task) {
		Thread t = new DeferredWorker();
		t.setName("deferred");
		return t;
	}
}

class DeferredWorker extends Thread {

	private boolean exit_flag = true;

	public DeferredWorker() {
		System.out.println("DeferredWorker Constructor");
	}

	@Override
	public void run() {
		System.out.println("DeferredWorker Thread is start here: "+this.getName());

		while (exit_flag) {
			if (ConcurrentRejectedExecutionHandler.runnable_queue.peek() != null) {
				System.out.println("Iterating the runnable queue == " + this.getName());
				Runnable task = ConcurrentRejectedExecutionHandler.runnable_queue.poll();
				if (task != null) {
					task.run();
					if (ConcurrentRejectedExecutionHandler.runnable_queue.isEmpty())
						this.exit_flag = false;
				}
			}
		}
		System.out.println("DeferredWorker Thread is end here.");
	}
}

class RejectedHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
		System.out.println("Somebody turned off the thread pool executor.. Need to complete the rejected task..");
		//Implementations may even decide to queue the task for deferred execution.
		System.out.println("Adding rejected task to runnable queue -- "+ ConcurrentRejectedExecutionHandler.runnable_queue.add(task));
	}
}

class WorkerThread implements Runnable {
	private String description;

	public WorkerThread(String description) {
		this.description = description;
		System.out.println("WorkerThread Constructor");
	}

	public WorkerThread() {
		System.out.println("WorkerThread Constructor");
	}

	@Override
	public void run() {
		System.out.println("Thread -- " + description+" Doing work....");
	}
}
