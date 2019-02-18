package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassLoaderExample  {
	
	public static void main(String[] args) {
		JavaClassLoader javaClassLoader = new JavaClassLoader();
		javaClassLoader.invokeClassMethod("main.ClassLoaderExample$MyClass", "sayHello");
	}

	public static class JavaClassLoader extends ClassLoader {
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void invokeClassMethod(String classBinName, String methodName){
			try {
				// Create a new JavaClassLoader 
				ClassLoader classLoader = this.getClass().getClassLoader();
				
				// Load the target class using its binary name
				Class loadedMyClass = classLoader.loadClass(classBinName);
				
				System.out.println("Loaded class name: " + loadedMyClass.getName());
				
				// Create a new instance from the loaded class
				Constructor constructor = loadedMyClass.getConstructor();
				Object myClassObject = constructor.newInstance();
				
				// Getting the target method from the loaded class and invoke it using its name
				Method method = loadedMyClass.getMethod(methodName,String.class);
				String arg = new String("Ganesh");
				System.out.println("Invoked method name: " + method.getName()+" with argument: "+arg);
				String returnVal = (String)method.invoke(myClassObject,arg);
				System.out.println("Return Value = "+returnVal);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public static class MyClass {
		
		public MyClass() {
			System.out.println("MyClass Constructor");
		}
		
		public String sayHello(String arg) {
			System.out.println("Inside the method sayHello");
			String str = "Hello "+arg+" !!! How are you ?";
			return str;
		}
	
	}
}