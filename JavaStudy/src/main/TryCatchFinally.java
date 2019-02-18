package main;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class TryCatchFinally {

	public static void main(String[] args) {
		
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
				System.out.println("Got Exception "+e.getMessage());
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				System.out.println("Here "+errors);
			}
			
		});
		
		TryCatchFinally o = new TryCatchFinally();
		o.testGlobalExceptionHandler();
		System.out.println("-------------------------");
		//System.out.println(o.changeMessage1("changeMessage1 Hello"));
		//System.out.println("-------------------------");
		//System.out.println(o.changeMessage2("changeMessage2 Hello"));
		System.out.println("-------------------------");
		//System.out.println(o.changeMessage3("changeMessage3 Hello"));
		
	}

/*1) You can write return statement in try,catch,finally block but in this case do not write return at the end of method
		Otherwise the code will become unreachable and will not compile.
2) Writing return statement only in try block is not sufficient you should write at least in catch,finally or end of method.
		Otherwise the program will not compile and saying 'This method must return a result of type xxxx'
3) Always write return statement in catch and finally block because if any exception raised in catch block will not be hamper on the method.
   Result will be the return value of finally block
4) Do not write return statement only in catch block because if any exception raised in catch block then it will not returning result value,
   showing the print stack of exception
*/

	public void testGlobalExceptionHandler() {
		System.out.println("Testing Global Exception Handler");
		int a=10/0;
	}
	
	public String changeMessage1(String message) {
		int x=10;
		boolean flag=true;
		try {

			if(flag) {
				System.out.println("throw new Exception(\"My Exception\");");
				throw new Exception("My Exception");
			}
			message = message+" Try";
			System.out.println("Try="+message);
			//throw new Exception("Test"); 		// Label 1
			return message;  					// Label 2
		} catch(Exception e) {
			x = 10/0;
			message = message+" Catch";
			System.out.println("Catch="+message);
			return message; 					// Label 3
		} finally {
			
			message=message+" Finally";
			System.out.println("finally="+message);
			//System.exit(0); 					// Label 4
			return message; 					// Label 5
		}
		
		//return message; 						// Label 6

	}
	
	public String changeMessage2(String message) {
		
		try {
			message = message+" Try";
			System.out.println("Try="+message);
			return message;  					// Label 2
		} catch(Exception e) {
			message = message+" Catch";;
			System.out.println("Catch="+message);
			//return; 					// Label 3
		} finally {
			message=message+" Finally";
			System.out.println("finally="+message);
			//System.exit(0); 					// Label 4
			//return message; 					// Label 5
		}
		
		return message; 						// Label 6

	}
	
	public String changeMessage3(String message) {
		boolean flag=true;
		try {
			if(flag) {
				System.out.println("throw new Exception(\"My Exception\");");
				throw new Exception("My Exception");
			}
			message = message+" Try";
			System.out.println("Try="+message);
			return message;  					// Label 2
		} catch(Exception e) {
			message = message+" Catch";;
			System.out.println("Catch="+message);
			return message; 					// Label 3
		} finally {
			message=message+" Finally";
			System.out.println("finally="+message);
			//System.exit(0); 					// Label 4
			//return message;; 					// Label 5
		}
		
		//return message; 						// Label 6

	}
	
}
