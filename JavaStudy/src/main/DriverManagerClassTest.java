package main;

public class DriverManagerClassTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		try {
				Class.forName("main.DriverClass");
		    } catch (ClassNotFoundException e) {
		    	e.printStackTrace();
		    }

		Thread t = DriverManagerClass.getThread();
		t.start();
		t.join();
			
		System.out.println("End");
	}
	
}
//-----------------------------------------------------
class DriverManagerClass {
	public static Thread testThread = null;

	public static void registerDriver(Thread xThread) {
		testThread = xThread;
	}

	public static Thread getThread() {
		return testThread;
	}
}
//-----------------------------------------------------
class DriverClass {
	public static Thread testThread; 	
    static {
    	System.out.println("Creating Driver Thread.");
    	testThread = new Thread() {
    				@Override
    				public void run() {
    						  super.run();
                              System.out.println("Driver Thread is running");
    				}
    			};
    	System.out.println("Registering Driver Thread in DriverManagerClass");
    	DriverManagerClass.registerDriver(testThread);
    } //End of static block
}
