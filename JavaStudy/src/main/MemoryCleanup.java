package main;

import java.lang.instrument.Instrumentation;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MemoryCleanup {
	
	public static void main(String args[]) {
		MemoryCleanup test = new MemoryCleanup();
        test.useThisObject(new Object());
    }
	
	private <T>void useThisObject(T obj) {
		System.out.println("Memory Consumation Before:"+Runtime.getRuntime().freeMemory()); 	
		ReferenceQueue<T> ref_queue = new ReferenceQueue<T>();
		PhantomReference<T> ref = new PhantomReference<T>(obj, ref_queue); // if this line isn't an assignment, the GC wouldn't collect the object no matter how hard I force it to 
	    //obj = null; // if you make it to null then it enqueue's in the ReferenceQueue immediately otherwise enqueue's automatically when GC think.  
		cleanTheMemory(ref_queue);
	    goOutOfMemnory(); // Calling this method to go out of memory
	    System.out.println("Memory Consumation after:"+Runtime.getRuntime().freeMemory());
	}
	
	private <T> void cleanTheMemory(final ReferenceQueue<T> ref_queue) {
		new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                System.out.println("Removing Object from Memory.....");
                boolean removed = false;
                while (!removed) {
                    try {
                        ref_queue.remove(1000); // it is blocking the flow unless any object available or time lapsed after specified time
                        //ref_queue.remove(); // it is blocking the flow unless any object available, you must set Obj to null explicitly otherwise the program will not terminate unless the Garbage collection have not done 
                        removed = true;
                        System.out.println("Object get removed from Memory.");
                    } catch (InterruptedException e) { // ignore
                    }
                }
            }
        }).start();
    }
	
	private void goOutOfMemnory() {
	        try {
	            int len = (int) java.lang.Math.min(java.lang.Integer.MAX_VALUE, Runtime.getRuntime().maxMemory());
	            Object[] arr = new Object[len];
	        } catch (Throwable e) {
	            // System.out.println(e);
	        }
	    }
}
