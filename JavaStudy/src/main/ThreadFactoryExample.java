package main;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryExample {

	public static void main(String[] args) {
		
		System.out.println("Program Start");
		
		MyCustomThreadFactory myCustomThreadFactory = new MyCustomThreadFactory(new MyCustomUncaughtExceptionHandler());
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
		threadPoolExecutor.setThreadFactory(myCustomThreadFactory);
		threadPoolExecutor.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
		threadPoolExecutor.prestartAllCoreThreads();
		
		threadPoolExecutor.execute(new MyXThread("Java"));
		threadPoolExecutor.execute(new MyXThread(".Net"));
		//threadPoolExecutor.execute(new MyXThread("VB"));
		
		Future<String> returnValue= threadPoolExecutor.submit(new MyYThread("Callable Java"));
		
		try {
			System.out.println("Callable Java return value = "+returnValue.get());
		} catch (InterruptedException e1) {
			System.out.println("Exception for Callable Java InterruptedException= "+e1.getMessage());
		} catch (ExecutionException e1) {
			System.out.println("Exception for Callable Java ExecutionException= "+e1.getMessage());
		}
		
		threadPoolExecutor.execute(new MyXThread("VBA"));
		threadPoolExecutor.execute(new MyXThread("Oracle"));
		
		threadPoolExecutor.shutdown();
		//Let allow submitted worker thread to complete task so the program will close safely
		boolean done = false;
		try {
			done = threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
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

class MyRejectedExecutionHandler implements RejectedExecutionHandler {
	
	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		Thread thread = new Thread(runnable);
		System.out.println("Thread task is rejected. Thread Name : = "+thread.getName());
	}
}

class MyCustomThreadFactory implements ThreadFactory {

	private MyCustomUncaughtExceptionHandler customUncaughtExceptionHandler;
	
	public MyCustomThreadFactory(MyCustomUncaughtExceptionHandler customUncaughtExceptionHandler) {
		this.customUncaughtExceptionHandler=customUncaughtExceptionHandler;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable);
		System.out.println("Thread Name : = "+thread.getName());
		thread.setDefaultUncaughtExceptionHandler(customUncaughtExceptionHandler);
		//thread.start(); // Do not call this method otherwise IllegalThreadStateException will generate
		return thread;
	}
}

class MyCustomUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.println("Exception occured in thread Name ["+thread.getName()+ "] :="+throwable.getMessage());
	}
}

class MyXThread implements Runnable {

	private String technologyName;
	
	public MyXThread(String technologyName) {
		this.technologyName=technologyName;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Technology Name="+technologyName+" Start");
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int a = 1/0; // Raise an Uncaught Exception
		a=a+1;
		
		System.out.println("Technology Name="+technologyName+" End");
	}
	
	public String getTechnologyName() {
		return technologyName;
	}
	
}

class MyYThread implements Callable<String> {

	private String technologyName;
	
	public MyYThread(String technologyName) {
		this.technologyName=technologyName;
	}

	@Override
	public String call() throws Exception {
		try {
			System.out.println("Technology Name="+technologyName+" Start");
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int a = 1/0; // Raise an Uncaught Exception
		a=a+1;
		
		System.out.println("Technology Name="+technologyName+" End");
		return technologyName;
	}

	public String getTechnologyName() {
		return technologyName;
	}

}
