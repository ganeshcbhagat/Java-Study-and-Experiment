package main;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.ClassPhantom.Referred;

public class StrongWeakSoftPhantomReference {


	public static void main(String[] args) {
		
		ClassStrong classStrong = new ClassStrong();
		classStrong.test();
		
		ClassSoft classSoft = new ClassSoft();
		try {
			classSoft.test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		ClassWeak classWeak = new ClassWeak();
		try {
			classWeak.test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ClassPhantom classPhantom = new ClassPhantom();
		try {
			classPhantom.test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ClassStrong {

	public static class Referred {
		
		public String message="Original Message";
		
		protected void finalize() {
			System.out.println("Good bye cruel world");
		}
	}

	public static void collect() throws InterruptedException {
		System.out.println("Suggesting collection");
		System.gc();
		System.out.println("Sleeping");
		Thread.sleep(200);
	}
	
	@SuppressWarnings("unused")
	public void test() {
		System.out.println("Creating strong references");
		// This is a strong reference. The object will only be collected if all references to it disappear.
		Referred strong = new Referred();
		strong.message="New modified Message";
		// Attempt to claim a suggested reference.
		try {
			Thread.sleep(200);
			ClassStrong.collect();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Removing reference");
		// The object may now be collected.
		strong = null;
		
		try {
			ClassStrong.collect();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(strong==null) {
        	System.out.println("Strong Object get garbage collected");
        } else {
        	System.out.println("yet Strong Object is not garbage collected message:"+strong.message);
        }
	        
		System.out.println("Done");
		
	}
}

class ClassSoft {
	 
    public static class Referred {
    	
    	public String message="Original Message";
    	
        protected void finalize() {
            System.out.println("Good bye cruel world");
        }
    }
 
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(200);
    }
 
    public void test() throws InterruptedException {
        System.out.println("Creating soft references");
 
        // This is a soft reference. The object will be collected only if no strong references exist and the JVM really needs the memory.
        Referred strong = new Referred();
        strong.message="New modified Message";
        SoftReference<Referred> soft = new SoftReference<Referred>(strong);
 
        // Attempt to claim a suggested reference.
        ClassSoft.collect();
 
        System.out.println("Removing reference");
        // The object may but highly likely wont be collected.
        strong = null;
        ClassSoft.collect();
 
        System.out.println("Consuming heap");
        try
        {
            // Create lots of objects on the heap
            List<ClassSoft> heap = new ArrayList<ClassSoft>(100000);
            while(true) {
                heap.add(new ClassSoft());
            }
        }
        catch (OutOfMemoryError e) {
            // The soft object should have been collected before this
            System.out.println("Out of memory error raised");
        }
 
        Referred softRef = soft.get();
        if(softRef==null) {
        	System.out.println("Soft Object get garbage collected");
        } else {
        	System.out.println("yet Soft Object is not garbage collected message:"+softRef.message);
        }
        
        System.out.println("Done");
    }
 
}

class ClassWeak {
	 
    public static class Referred {
    	
    	public String message="Original Message";
    	
        protected void finalize() {
            System.out.println("Good bye cruel world");
        }
    }
 
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(200);
    }
 
    public void test() throws InterruptedException {
        System.out.println("Creating weak references");
 
        // This is now a weak reference.
        // The object will be collected only if no strong references.
        Referred strong = new Referred();
        strong.message="New modified Message";
        WeakReference<Referred> weak = new WeakReference<Referred>(strong);
 
        // Attempt to claim a suggested reference.
        ClassWeak.collect();
 
        System.out.println("Removing reference");
        // The object may be collected.
        strong = null;
        ClassWeak.collect();
        
        Referred weakRef = weak.get();
        if(weakRef==null) {
        	System.out.println("Weak Object get garbage collected");
        } else {
        	System.out.println("yet Weak Object is not garbage collected message:"+weakRef.message);
        }
        
        System.out.println("Done");
    }
}

class ClassPhantom {
	 
    public static class Referred {
    	public String message="Original Message";
        // Note that if there is a finalize() method PhantomReference's don't get appended to a ReferenceQueue
    }
 
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(200);
    }
 
    public void test() throws InterruptedException {
        System.out.println("Creating phantom references");
 
        // The reference itself will be appended to the dead queue for clean up.
        ReferenceQueue<Referred> dead = new ReferenceQueue<Referred>(); 
 
        // This map is just a sample we might use to locate resources we need to clean up.
        @SuppressWarnings("rawtypes")
		Map<Reference,String> cleanUpMap = new HashMap<Reference,String>();
 
        // This is now a phantom reference.
        // The object will be collected only if no strong references.
        Referred strong = new Referred();
        strong.message="New modified Message";
        
        PhantomReference<Referred> phantom = new PhantomReference<Referred>(strong, dead);
        cleanUpMap.put(phantom, "You need to clean up some resources, such as me!");
 
        strong = null;
 
        // The object may now be collected
        ClassPhantom.collect();
 
        Referred phantomRef = phantom.get();
        if(phantomRef==null) {
        	System.out.println("Phantom Object get garbage collected");
        } else {
        	System.out.println("yet Phantom Object is not garbage collected message="+phantomRef.message);
        }
        
        // Check for 
        Reference<? extends Referred> reference = dead.poll();
        if (reference != null) {
            System.out.println("reference != null = "+cleanUpMap.remove(reference));
        }
        System.out.println("Done");
    }
}
