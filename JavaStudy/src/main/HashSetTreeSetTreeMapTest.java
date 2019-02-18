package main;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSetTreeSetTreeMapTest {

	public static void main(String[] args) {

		//To get uniqueness in the HashSet, LinkedHashSet, HashMap, HashTable  you must override hashCode and equal method
		//while using TreeSet/TreeMap the key Class should implement the Comparable interface or you need to provide the Comparator to Collection
		
		HashSet<HashSetKeyTest> li = new HashSet<HashSetKeyTest>();
		li.add(new HashSetKeyTest("1"));
		li.add(new HashSetKeyTest("2"));
		li.add(new HashSetKeyTest("3"));
		li.add(new HashSetKeyTest("1")); // Adding duplicate object
		System.out.println("HashSet = "+li);
		
		//----------------------------------------------------------------
		
		//TreeSet<TestTreeSetClass> treeSet = new TreeSet<TestTreeSetClass>(new MyComparator1());
		TreeSet<TestTreeSetClass> treeSet = new TreeSet<TestTreeSetClass>();
		treeSet.add(new TestTreeSetClass("1"));
		treeSet.add(new TestTreeSetClass("3"));
		treeSet.add(new TestTreeSetClass("2"));
		treeSet.add(new TestTreeSetClass("5"));
		//treeSet.add(null);// throwing exception
		treeSet.add(new TestTreeSetClass("1")); //  Added duplicate key, Key is same but still allowed to add because it is similar to first element  
		treeSet.add(new TestTreeSetClass("5")); // Added duplicate key
		
		System.out.println("TreeSet= "+treeSet);
		
		//----------------------------------------------------------------
		
		//TreeMap<TestTreeMapClass,String> treeMap = new TreeMap<TestTreeMapClass,String>();
		TreeMap<TestTreeMapClass,String> treeMap = new TreeMap<TestTreeMapClass,String>(new MyComparator2());
		treeMap.put(new TestTreeMapClass("1"),"1");
		treeMap.put(new TestTreeMapClass("3"),"3");
		treeMap.put(new TestTreeMapClass("2"),"2");
		treeMap.put(new TestTreeMapClass("5"),"5");
		treeMap.put(null,"52"); //If the key is implementing the comparable then null will not allowed
		                        // to allow you need to provide the comparator than null need to handle in Comparator
		treeMap.put(null,"155"); 
		treeMap.put(new TestTreeMapClass("5"),"5222"); // Added duplicate key
		treeMap.put(new TestTreeMapClass("1"),"1013");
		treeMap.put(new TestTreeMapClass("5"),"545"); // Added duplicate key
		System.out.println("TreeMap= "+treeMap);
		System.out.println("TreeMap get Value "+treeMap.get(new TestTreeMapClass("1")));
	}
}

/*class HashSetKeyTest implements Comparable<HashSetKeyTest> {*/
class HashSetKeyTest {
	String str;
	
	public HashSetKeyTest() {
		
	}
	
	public HashSetKeyTest(String str) {
		this.str = str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}
	
	@Override
	public String toString() {
		return str;
	}


	@Override
	public int hashCode() {
		return str.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		HashSetKeyTest keyTestTemp = (HashSetKeyTest)object;
		return this.str.equals(keyTestTemp.str);
	}
	
	/*@Override
	public int compareTo(HashSetKeyTest c1) {
		return (c1==null) ? -1 : c1.getStr().equals(this.getStr()) ? 0 : 1;
	}*/
	
}

class TestTreeSetClass implements Comparable<TestTreeSetClass> {
//class TestTreeSetClass {
	String str;
	
	public TestTreeSetClass() {
		
	}
	
	public TestTreeSetClass(String str) {
		this.str = str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}
	
	@Override
	public String toString() {
		return str;
	}

/*	@Override
	public int hashCode() {
		return str.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		TestTreeSetClass keyTestTemp = (TestTreeSetClass)object;
		return this.str.equals(keyTestTemp.str);
	}*/
	
	@Override
	public int compareTo(TestTreeSetClass c1) {
		return this.getStr().compareTo(c1.getStr());
	}
	
}

class MyComparator1 implements Comparator<TestTreeSetClass> {

	@Override
	public int compare(TestTreeSetClass c1, TestTreeSetClass c2) {
		if(c1==null || c2==null) {
			return 0;
		}
		return c1.getStr().compareTo(c2.getStr());
	}
	
}

class MyComparator2 implements Comparator<TestTreeMapClass> {

	@Override
	public int compare(TestTreeMapClass c1, TestTreeMapClass c2) {
		if(c1==null || c2==null) {
			return 0;
		}
		
		return c1.getStr().compareTo(c2.getStr());
	}
	
}

//class TestTreeMapClass implements Comparable<TestTreeMapClass> {
class TestTreeMapClass {
	
	String str;
	
	public TestTreeMapClass() {
		
	}
	
	public TestTreeMapClass(String str) {
		this.str = str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}
	
	@Override
	public String toString() {
		return str;
	}
	
	/*@Override
	public int compareTo(TestTreeMapClass c1) {
		return c1==null? -1 : this.getStr().compareTo(c1.getStr());
	}*/
}
