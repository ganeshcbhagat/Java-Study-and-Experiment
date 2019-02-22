package main.study.methodOverriding;

public class TestOverrideMethod {

	public static void main(String[] args) {

		System.out.println("---------------Start------------------");
		StringUtil obj1 = new StringUtilImpl();
		System.out.println(obj1.toUpperCase("This is String_Util_Impl"));
		
		StringUtil  obj2 = new StringUtilImplWithoutMethodOverride();
		System.out.println(obj2.toUpperCase("This is String_Util_Impl_Without_Method_Override"));
		
		Thread thread1 = new Thread(new RunnableImplWithoutRunMethodOverriding());
		thread1.start();
		System.out.println("--------------End-------------------");
		
	}

	static interface StringUtil {
		public String toUpperCase(String msg);
	}
	
	static class StringUtilImpl implements StringUtil {
		@Override
		public String toUpperCase(String msg) {
			return "StringUtilImpl:"+msg.toUpperCase();
		}
	}
	
	static class UnknownToUpperCaseClass {
		public String toUpperCase(String msg) {
			return "UnknownMiddleClass:"+msg.toUpperCase();
		}
	}
	
	static class StringUtilImplWithoutMethodOverride extends UnknownToUpperCaseClass implements StringUtil {
		//toUpperCase(..) method is not overridden here
	}
		
	static class UnknownRunMethodClass {
		public void run() {
			System.out.println("Inside UnknownRunMethodClass");
		}
	}
	
	static class RunnableImplWithoutRunMethodOverriding extends UnknownRunMethodClass implements Runnable {
		//run(..) method is not overridden here
	}
	
}
