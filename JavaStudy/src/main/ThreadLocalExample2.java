package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample2 {

    public static void main(String[] args) {
    	DateFormatterUtil dateFormatterUtilInstance = new DateFormatterUtil();

        Thread thread1 = new Thread(dateFormatterUtilInstance,"Thread-1");
        Thread thread2 = new Thread(dateFormatterUtilInstance,"Thread-2");

        thread1.start();
        thread2.start();

        try {
			thread1.join(); //wait for thread 1 to terminate
			thread2.join(); //wait for thread 2 to terminate
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
   
    }

	public static class DateFormatterUtil implements Runnable {
      
		//each thread can get the different value
		private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
			protected SimpleDateFormat initialValue() {
				  System.out.println("Initializing SimpleDateFormat for - " + Thread.currentThread().getName() );
		          return new SimpleDateFormat("dd/MM/yyyy");
			}
		};
		
        @Override
        public void run() {
        	 System.out.println(Thread.currentThread().getName()+" Date formatter:" + dateFormatThreadLocal.get().toPattern());
             System.out.println("Formatted date is " + dateFormatThreadLocal.get().format(new Date()));
        	
        }
    }
}
