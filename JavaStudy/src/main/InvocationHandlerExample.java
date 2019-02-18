package main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerExample {

	public static void main(String[] args) {
		Task task = (Task)ProxyFactory.newInstance(new TaskImpl());
		System.out.println("------------------------------------------------------------");
		task.setData("Test");
		System.out.println("------------------------------------------------------------");
		System.out.println(task.getCurrentTimeMillis());
		System.out.println("------------------------------------------------------------");
		task.printing();
		System.out.println("------------------------------------------------------------");
		Task t = task.getThis();
		System.out.println("Return this= "+t);
	}
//-----------------------------------------------------------------------------------
	private static interface Task {
		public void setData(String data);
		public long getCurrentTimeMillis();
		public Task getThis();
		public void printing();
	}
//-----------------------------------------------------------------------------------
	private static class TaskImpl implements Task {
		
		@Override
		public void setData(String data) {
			System.out.println(data+ " Data is saved");
		}

		@Override
		public long getCurrentTimeMillis() {
			return System.currentTimeMillis();
		}
		
		@Override
		public Task getThis() {
			return this;
		}
		
		@Override
		public void printing() {
			System.out.println("In Printing method");
		}
		
		@Override
		public String toString() {
			return "Its me.....";
		}
	}
//-----------------------------------------------------------------------------------
	private static class InvocationHandlerImpl implements InvocationHandler {
		
		private Object obj;
		public InvocationHandlerImpl(Object obj) {
			this.obj = obj;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object result = null;
			System.out.println("<"+method.getName()+"> method get executing.");
			
	        try{
	        	if(method.getName().indexOf("getThis")>-1) {
			       System.out.println("...getThis Method Executing...");
		        } else if(method.getName().indexOf("get")>-1) {
		           System.out.println("...get Method Executing...");
	        	} else if(method.getName().indexOf("set")>-1) {
	        		System.out.println("...set Method Executing...");
	        	} else {
	        		System.out.println("...No argument method Executing...");
	        	}
	        	
	        	System.out.println("-----------------Before method Executing-----------------");
	        	result = method.invoke(obj, args);
	        	System.out.println("-----------------After method Executing-----------------");
	        	
		    } catch (InvocationTargetException e) {
		        throw e;
		    } catch (Exception e) {
		        throw e;
		    }
	        return result;
		}
	}
//-----------------------------------------------------------------------------------
	private static class ProxyFactory {
		public static Object newInstance(Object ob) {
			//return Proxy.newProxyInstance(ob.getClass().getClassLoader(), new Class<?>[] { Task.class }, new InvocationHandlerImpl(ob));
			return Proxy.newProxyInstance(ob.getClass().getClassLoader(), ob.getClass().getInterfaces(), new InvocationHandlerImpl(ob));
		}
	}
}