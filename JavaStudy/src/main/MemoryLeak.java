package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryLeak {
	
	public static void main(String... args) {
		System.out.println("Start");
		try {
	      Thread.sleep(12000);
	      method("Memory Leak Thread 1",1000);
	      try {
				Thread.sleep(300);
				//System.gc();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	      method("Memory Leak Thread 2",500);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
		
		System.out.println("End");
	}

	private static void method(final String threadName, final int numberOfRepetation) {
		final Map<TestClass, String> mapObj1 = new HashMap<TestClass, String>();
	    Thread t1 = new Thread (new Runnable() {
	  	  @Override
	  		public void run() {
	  		  for(int i=0;i<numberOfRepetation; i++) {
	  		    	 try {
							Thread.sleep(300);
							//System.gc();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	  		    	 TestClass testObj = new TestClass("Key-"+Math.random()*10000);
	  		    	 System.out.println(threadName+" Adding = "+testObj);
	  		    	 mapObj1.put(testObj, "value");
	  		      }
	  		}
	    });
	    t1.setName(threadName);
	    t1.start();
	}
}

class TestClass {
	
	private final String key;
	private byte[] padding;
	
	public TestClass(String key) {
	    this.key = key;
	    this.padding = new byte[1024*1024]; //1Mbyte
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + Arrays.hashCode(padding);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestClass other = (TestClass) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (!Arrays.equals(padding, other.padding))
			return false;
		return true;
	}
	
}
