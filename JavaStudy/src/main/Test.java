package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.annotation.Annotation;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

import main.SerializationTest.Employee;
import sun.misc.Unsafe;

public class Test {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.out.println("Start");

		// ClassLoader classLoader = Test.class.getClassLoader();
		/*
		 * ClassLoader classLoader = ClassLoader.getSystemClassLoader(); URL
		 * packageUrl = classLoader.getResource("main/servers"); DataInputStream
		 * dataInputStream = new DataInputStream(packageUrl.openStream());
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(dataInputStream)); String line = null;
		 * 
		 * while ((line = bufferedReader.readLine()) != null) {
		 * if(line.endsWith(".class")) { //Class cx =
		 * Class.forName(line.replaceAll(".class", "")).getEnclosingClass();
		 * System.out.println(line); Class cx =
		 * Class.forName("main.servers."+line.replaceAll(".class", ""));
		 * for(Class x : cx.getInterfaces()) { System.out.println(
		 * "Implementation: "+x.getName()+(cx.getSuperclass()!=null?
		 * " : Super Class: "+cx.getSuperclass():"")); } } }
		 * 
		 * bufferedReader.close();
		 */

		
/*		  NavigableSet<String> citySet = new ConcurrentSkipListSet<String>();
		  citySet.add("New Delhi"); citySet.add("Mumbai");
		  citySet.add("Chennai"); citySet.add("Hyderabad"); 
		  
		  System.out.println("---- Traversing the set-----");
		  Iterator<String> itr = citySet.iterator();
		  while(itr.hasNext()){
			  System.out.println("Value -  " + itr.next()); 
		  }
		  System.out.println("--------------");
		  System.out.println("Higher - "+ citySet.higher("Hyderabad"));
		  System.out.println("Lower - " + citySet.lower("Hyderabad"));
		  
		  System.out.println("---- Tail Set -----");
		  
		  Set<String> set = citySet.headSet("Hyderabad",false);
		  
		  itr = set.iterator();
		  while(itr.hasNext()){
			  System.out.println("Value -  " + itr.next()); 
		  }
		  System.out.println(citySet);*/
		 

		// ZonedDate b = new ZonedDate();
		/*
		 * BaseDate<ZonedDate> b = new ZonedDate();
		 * b.withYear(2014).buildCalendar().withYear(2017).buildCalendar();
		 */
		
		/*int array[] = {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(reverseArray(array)));*/
		
	/*	int array[] = {10,2,3,4,3,1,33,10};
		System.out.println(Arrays.toString(removeDuplicateElementInArray(array)));
		
		System.out.println(Arrays.binarySearch(array, 33));
		int array2[] = Arrays.copyOf(array, array.length+2);
		System.out.println(Arrays.toString(array2));*/
		
		/*System.out.println(reverseNumber(123456789));
		
		System.out.println(reverseString_1("hello"));
		System.out.println(reverseString_2("hello"));
		System.out.println(reverseString_3("hello"));*/
		
		A a = new B();
		a.print();
		System.out.println("End");
	}
	
	static class A {

		int i=0;
		public A() {
			i=10;
			print();
		}
		public void print() {
			i++;
			System.out.println("A: "+i);
		}
	}
	
	static class B extends A {
		
		public B() {
			print();
		}
		public void print() {
			i=i+10;
			System.out.println("B: "+i);
		}
	}
	
	public static Map<Integer, Integer> findCountOfDuplicateElement_1(int array[]) {
		
		Map<Integer, Integer> duplicateElementMap = new HashMap<Integer, Integer>(array.length);
		
		for(int element: array) {
			if(duplicateElementMap.get(new Integer(element))==null) {
				duplicateElementMap.put(new Integer(element), new Integer(1));
			} else {
				Integer count = duplicateElementMap.get(new Integer(element));
				duplicateElementMap.put(new Integer(element), count+new Integer(1));
			}
		}
		return duplicateElementMap;
	}
	
	public static boolean isDuplicatePresentInAnArray(int array[]) {
		
		boolean flag = false;
		Arrays.sort(array);
		
		for(int index=0;index<array.length-1;index++) {
			if(array[index]==array[index+1]) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static int[] reverseArray(int array[]) {
		int arrayTemp[] = array.clone();
		int temp;
		for(int i=0;i<(arrayTemp.length/2);i++) {
			temp = arrayTemp[array.length-i-1];
			arrayTemp[array.length-i-1]=arrayTemp[i];
			arrayTemp[i]=temp;
		}
		return arrayTemp;
	}
	
	public static int[] removeDuplicateElementInArray(int array[]) {
		if(array==null || array.length==0) return array;
		
		Arrays.sort(array);
		
		int arrayTemp[] = new int[array.length];
		int previous = array[0];
		int temp;
		arrayTemp[0] = previous; 
		for(int i=1; i<array.length; i++) {
			temp = array[i];
			if(temp!=previous) {
				arrayTemp[i]=temp;	
			}
			previous = temp;
		}
		return arrayTemp;
	}
	
	public static int reverseNumber(int number) {
		int reverse=0;
		int reminder=0;
		
		do {
			reminder = number%10;
			reverse =  reverse*10 + reminder;
			number = number/10;
		} while(number>0); 
		
		return reverse;
	}
	
	public static String reverseString_1(String inputStr) {
		if(inputStr==null || inputStr.isEmpty()) return "";
		StringBuilder reverseString=new StringBuilder(inputStr);
		return reverseString.reverse().toString();
	}
	
	public static String reverseString_2(String inputStr) {
		if(inputStr==null || inputStr.isEmpty()) return "";
		String reverseString = new String();
		
		for(int index=inputStr.length()-1; index>=0; index--) {
			reverseString = reverseString + inputStr.charAt(index);	
		}
		return reverseString;
	}
 
	public static String reverseString_3(String inputStr) {  
	    // exit or termination condition  
	    if ((null == inputStr) || (inputStr.length( )  <= 1)) {  
	        return inputStr;  
	    }
	    // put the first character (i.e. charAt(0)) to the end. String indices are 0 based and recurse with 2nd character (i.e. substring(1)) onwards    
	    return reverseString_3(inputStr.substring(1)) + inputStr.charAt(0);  
	} 
	
}
