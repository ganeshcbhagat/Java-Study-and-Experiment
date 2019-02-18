package main;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadUncaughtExceptionHandlerExample {
	
	public static void main(String[] args)    {
	
		Thread tThread = new Thread(new TestThread1(),"Test Thread1");
		tThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Exception occured in Thread" + t.getName());
			}
		});
		tThread.start();
		
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Default Exception handler for all Thread=" + t.getName());
			}
		});
		
		Thread t1Thread = new Thread(new TestThread2(),"Test Thread2");
		t1Thread.start();
		
	}
	
	static class TestThread1 implements Runnable {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++){
				if(i==3) {
					System.out.println("Raising an Exception" + i);
					throw new ArithmeticException();
				}
			}
		}
	}
	
	static class TestThread2 implements Runnable {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++){
				if(i==3) {
					System.out.println("Raising an Exception" + i);
					throw new ArithmeticException();
				}
			}
		}
	}
}
