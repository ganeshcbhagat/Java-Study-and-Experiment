package main;

public class ShutdownHookExample 
{
	public static void main(String[] args)throws Exception
	{  
		Runtime r=Runtime.getRuntime();  
		r.addShutdownHook(new Thread() {
		@Override
				public void run() {
					System.out.println("Run time hook thread start running....");
				}
		}); 
  
		System.out.println("Main thread is running...");
		try {
			System.out.println("Try block");
			int x = 2/0; // Raising divide by zero uncheck exception
		} catch(Exception e) {
			System.out.println("Catch block <Next step is exit the program> Exception= "+e.getMessage());
			System.exit(-1); // Closing the program abruptly
		} finally {
			System.out.println("Finally block");
		}
		System.out.println("Main thread is stopped.");
	}
}