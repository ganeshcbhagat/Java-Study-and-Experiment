package main;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer implements Cloneable {

	private static final String ConsumerName[]= {"RED","GREEN","BLUE","ORANGE"};
	private static final String MessageName[]= {"Message_RED","Message_GREEN","Message_BLUE","Message_ORANGE"};
	private static volatile boolean stopFlag = true;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, CloneNotSupportedException {
		//System.out.println("Start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ProducerConsumer a = new ProducerConsumer();
		a.processJob();
		
		System.out.println("End");
	}

	public void processJob() throws InterruptedException, ExecutionException, CloneNotSupportedException {
		int sleepCount = 0;
		long start=System.currentTimeMillis();
		
		//ExecutorService executorService = Executors.newFixedThreadPool(20);
		ExecutorService executorService = new ThreadPoolExecutor(20,20,5,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(20),Executors.defaultThreadFactory()) {
			
			@Override
			protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
				System.out.println("-----------Callable New Task-----------");
				return super.newTaskFor(callable);
			}
			
			@Override
			protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
				System.out.println("-----------Runnable New Task-----------");
				return super.newTaskFor(runnable, value);
			}
			
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("Before executing Task");
				super.beforeExecute(t, r);
			}
			
			@Override
			public void execute(Runnable command) {
				System.out.println("-----------Executing Task-----------");
				super.execute(command);
			}
			
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("-----------After executing Task-----------");
				super.afterExecute(r, t);
			}
			
		};
		
		BlockingQueue<ProducerConsumer.MessageService> queue = new ArrayBlockingQueue<ProducerConsumer.MessageService>(10);
		
		ArrayList<Future<Integer>> futureListObj = new ArrayList<Future<Integer>>();
		
		Thread gcThread = new Thread(new GarbageCollector());
		gcThread.setDaemon(true);
		gcThread.start();
		
		Thread monitorThread = new Thread(new TaskMonitor((ThreadPoolExecutor)executorService));
		monitorThread.start();
		
		int x=0;
		while(x<5) {
			String m = getConsumerName();
			queue.put(new MessageService(getMessageName()));
			//Future<Integer> futureObj = executorService.submit(new AConsumer((AProducer)this.clone(), queue, "Consumer:"+m));
	    	Future<Integer> futureObj = executorService.submit(new AConsumer(this, queue, "Consumer:"+m));
	    	futureListObj.add(futureObj);
	    	x=x+1;
		}
		
		executorService.shutdown();
	    executorService.awaitTermination(1, TimeUnit.MINUTES);
	    
	    int fSize = futureListObj.size();
	    COUNT_RESULT_LABEL:
		while(true) {
			    for(int i=0; i<fSize; i++) {
			    	if(!futureListObj.isEmpty()) {
			    		if(i>=0) {
					    	Future<Integer> futureObj = futureListObj.get(i);
					    	if(futureObj.isDone()) {
					    		sleepCount = sleepCount + futureObj.get();
					    		futureListObj.remove(futureObj);
					    		i=i-1;
					    	}
			    		}
			    	}
			    }
		    
			if(!futureListObj.isEmpty()) {
		    	fSize = futureListObj.size();
		    	continue COUNT_RESULT_LABEL;
		    } else {
		    	break COUNT_RESULT_LABEL;
		    }
		}
	    
	    System.out.println("Final Result="+sleepCount);
	    stopFlag=false;
	    System.out.println("Time span "+(System.currentTimeMillis()-start));
	}
	
	public static String getConsumerName() {
		Random ran = new Random();
		int x = ran.nextInt(ConsumerName.length-1) + 1;
		return ConsumerName[x];
	}
	public static String getMessageName() {
		Random ran = new Random();
		int x = ran.nextInt(MessageName.length-1) + 1;
		return MessageName[x];
	}
	
	public synchronized void printMsg(char msg[]) {
	//public void printMsg(char msg[]) {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("[");
		for(int i=0; i<msg.length; i++) {
			System.out.print(msg[i]);
		}
		System.out.print("]");
		System.out.println();
	}
	
	public class MessageService {
	    private String msg;
	    public MessageService(String str){
	        this.msg=str;
	    }

	    public String getMsg() {
	        return msg;
	    }
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	private static class GarbageCollector implements Runnable {
		@Override
		public void run() {
			//stopFlag is a private static volatile class member
			while(stopFlag) {
				System.gc();
			}
		}
	}
	
	private static class TaskMonitor implements Runnable {
		private ThreadPoolExecutor executor;
		public TaskMonitor(ThreadPoolExecutor executor) {
			this.executor = executor;
		}
		
		@Override
		public void run() {
			//stopFlag is a private static volatile class member
			while(stopFlag) {
				try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
				
				System.out.println(String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
						 	                        executor.getPoolSize(),	executor.getCorePoolSize(),
						 	                        executor.getActiveCount(),	executor.getCompletedTaskCount(),
						 	                        executor.getTaskCount(),	executor.isShutdown(),
						 	                        executor.isTerminated()));
			}
		}
		
	}
}


class AConsumer implements Callable<Integer> {
	private BlockingQueue<ProducerConsumer.MessageService> queue;
	private ProducerConsumer aProducer;
	private String consumerName;
	
	public AConsumer(ProducerConsumer aProducer, BlockingQueue<ProducerConsumer.MessageService> queue, String consumerName) {
		this.queue = queue;
		this.aProducer = aProducer;
		this.consumerName = consumerName;
	}
	
	@Override
	public Integer call() throws Exception {
		Random ran = new Random();
		int sleepCount = ran.nextInt(100) + 50;
		
		ProducerConsumer.MessageService ms = queue.take();
		System.out.println("["+consumerName +"] consuming "+ms.getMsg());
		
		char msg[] = {'h','e','l','l','o',' ','G','a','n','e','s','h'};
		aProducer.printMsg(msg);
		
		//Thread.sleep(sleepCount);
		Thread.sleep(550);
		
		System.out.println("["+consumerName +"] complete returning "+sleepCount);
		return sleepCount;
	}

}