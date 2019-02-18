package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program Start");
		int capacity=10;
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(capacity); // If capacity is reached to 10 then 
																				  //producer will wait until it gets drain by consumer 
		//BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
		Thread pThread = new Thread(new Producer(queue,3));
		Thread cThread1 = new Thread(new Consumer(queue,"Consumer 1"));
		Thread cThread2 = new Thread(new Consumer(queue,"Consumer 2"));
		Thread cThread3 = new Thread(new Consumer(queue,"Consumer 3"));
		
		pThread.start();
		cThread1.start();
		cThread2.start();
		cThread3.start();
		
		pThread.join();
		cThread1.join();
		cThread2.join();
		cThread3.join();
		
		System.out.println("Program Exit");
	}

	public static class Message {
	    private String msg;
	    public Message(String str){
	        this.msg=str;
	    }

	    public String getMsg() {
	        return msg;
	    }
	}
	
	public static class Producer implements Runnable {
		
		private int count=0;
		private int numberOfConsumer=0;
		private BlockingQueue<Message> queue = null;
		
		public Producer(BlockingQueue<Message> queue,int numberOfConsumer) {
			this.queue = queue;
			this.numberOfConsumer=numberOfConsumer;
		}
		
		@Override
		public void run() {
			while(count<=10) {
				System.out.println("Put Message="+count);
				try {
					//put() method is used to insert elements to the queue.
					//If the queue is full, it waits for the space to be available. It blocks the queue
					queue.put(new Message(""+count));
					Thread.sleep(100); // result will vary by removing Thread.sleep(100) or changing the sleep count 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count=count+1;
			}
			
			//adding exit message
	        Message msg = new Message("exit");
	        try {
	        	for(int i=0; i<=numberOfConsumer; i++) {
	        		queue.put(msg);
	        	}
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        System.out.println("Producer exit");
		}
	}
	
	public static class Consumer implements Runnable {
		
		private BlockingQueue<Message> queue = null;
		private String consumerName;
		
		public Consumer(BlockingQueue<Message> queue, String consumerName) {
			this.queue = queue;
			this.consumerName= consumerName;
		}
		
		@Override
		public void run() {
			 Message msg;
			 try {
				//take() method retrieves and remove the element from the head of the queue.
				 //If queue is empty it waits for the element to be available. It blocks the queue
				 while((msg = queue.take()).getMsg() !="exit") {
	            	System.out.println(consumerName+" taking Message "+msg.getMsg());
				 }
	         } catch (InterruptedException e) {
					e.printStackTrace();
			 }
			 System.out.println(consumerName+" exit");
		}
	}
}
