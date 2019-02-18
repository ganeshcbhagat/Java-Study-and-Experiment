package main;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program Start");
		TransferQueue<Message> queue = new LinkedTransferQueue<Message>(); //producer will wait until it gets drain by consumer 

		Thread pThread = new Thread(new Producer(queue));
		Thread cThread = new Thread(new Consumer(queue));
		
		pThread.start();
		cThread.start();
		
		pThread.join();
		cThread.join();
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
		
		int count=0;
		private TransferQueue<Message> queue = null;
		
		public Producer(TransferQueue<Message> queue) {
			this.queue = queue;
		}
		
		@Override
		public void run() {
			while(count<=10) {
				System.out.println("Put Message="+count);
				try {
					//put() method is used to insert elements to the queue.
					//If the queue is full, it waits for the space to be available. It blocks the queue
					queue.transfer(new Message(""+count));
					Thread.sleep(100); // result will vary by removing Thread.sleep(100) or changing the sleep count 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count=count+1;
			}
			
			//adding exit message
	        Message msg = new Message("exit");
	        try {
	        	queue.put(msg);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public static class Consumer implements Runnable {
		
		private TransferQueue<Message> queue = null;
		
		public Consumer(TransferQueue<Message> queue) {
			this.queue = queue;
		}
		
		@Override
		public void run() {
			 Message msg;
			 try {
				//take() method retrieves and remove the element from the head of the queue.
				 //If queue is empty it waits for the element to be available. It blocks the queue
				 while((msg = queue.take()).getMsg() !="exit") {
	            		System.out.println("Take Message "+msg.getMsg());	
				 }
	         } catch (InterruptedException e) {
					e.printStackTrace();
			 }
		}
	}
}
