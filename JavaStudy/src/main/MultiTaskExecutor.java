package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class MultiTaskExecutor {
 
    public static void main(String[] args) {
         
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandelerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, worksQueue, rejectionHandler) {
        	@Override
        	protected void beforeExecute(Thread t, Runnable r) {
        		super.beforeExecute(t, r);
        		System.out.println("Before Thread Name:"+r);
        	}
        	
        	@Override
        	protected void afterExecute(Runnable r, Throwable t) {
        		super.afterExecute(r, t);
        		System.out.println("After Thread Name:"+r);
        	}
        	
        };
        
        executor.prestartAllCoreThreads();
         
        List<Runnable> taskGroup = new ArrayList<Runnable>();
        taskGroup.add(new TaskOneX());
        taskGroup.add(new TaskTwoX());
        taskGroup.add(new TaskThreeX());
        
        worksQueue.add(new MultiRunnable(taskGroup));
        
        executor.shutdown();
        
        worksQueue.add(new MultiRunnable(taskGroup));
    }
}

class RejectedExecutionHandelerImpl implements RejectedExecutionHandler
{
    @Override
    public void rejectedExecution(Runnable runnable,ThreadPoolExecutor executor)
    {
        System.out.println(runnable.toString() + " : I've been rejected ! ");
    }
}

class MultiRunnable implements Runnable {
	 
    private final List<Runnable> runnables;
 
    public MultiRunnable(List<Runnable> runnables) {
        this.runnables = runnables;
    }
 
    @Override
    public void run() {
        for (Runnable runnable : runnables) {
             new Thread(runnable).start();
        }
    }
    
    @Override
    public String toString() {
    	return "[MultiRunnable thread]";
    }
}

class TaskOneX implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task One");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
    	return "[TaskOneX thread]";
    }
}
 
class TaskTwoX implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Two");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
    	return "[TaskTwoX thread]";
    }
}
 
class TaskThreeX implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Three");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
    	return "[TaskThreeX thread]";
    }
}