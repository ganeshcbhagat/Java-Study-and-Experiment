package main;

public class ThreadLocalExample {

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
			thread1.join(); //wait for thread 1 to terminate
			thread2.join(); //wait for thread 2 to terminate
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
    }

	public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(); //each thread can get the different value
        private String message; //all thread can get the same value 
        
        @Override
        public void run() {

        	threadLocal.set( (int) (Math.random() * 100D) );
        	
            setMessage("Hello Message : " +(int) (Math.random() * 100D));
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get());
            System.out.println(getMessage());
        }
        
        public String getMessage() {
			return message;
		}
        
        public void setMessage(String message) {
			this.message = message;
		}
        
    }
}
