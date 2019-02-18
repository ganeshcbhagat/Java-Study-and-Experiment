package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<KeyTest, String> hashmapObj = new  HashMap<KeyTest, String>();
		
		hashmapObj.put(null, "null 1"); // Adding new Value
		System.out.println("Null test 1 hashmapObj.get="+hashmapObj.get(null));
		hashmapObj.put(null, null); // Adding new Value
		System.out.println("Null test 2 hashmapObj.get="+hashmapObj.get(null));
		
		KeyTest keyTestObj = new KeyTest("Ganesh");
		System.out.println("hashCode  : "+keyTestObj.hashCode());
		hashmapObj.put(keyTestObj, "Ganesh Test"); // Adding new Value
		System.out.println("1) hashmapObj.get="+hashmapObj.get(keyTestObj));
		System.out.println("2) hashmapObj.get="+hashmapObj.get(new KeyTest("Ganesh")));
		
		// Here we are changing the keyName so after incorrect implementation of hashCode and equal method the return value will be null
		//If you are not overriding hashCode and equal method in KeyTest class then after changing the keyName still you will get the correct object
		//its using default hashCode and equal method

		keyTestObj.setKeyName("Rajesh");
		System.out.println("hashCode 2 : "+keyTestObj.hashCode());

		System.out.println("3) hashmapObj.get="+hashmapObj.get(keyTestObj));
		System.out.println("31) hashmapObj.get="+hashmapObj.get(new KeyTest("Rajesh")));
		System.out.println("32) hashmapObj.get="+hashmapObj.get(new KeyTest("Ganesh")));
		
		keyTestObj.setKeyName("Ganesh");
		System.out.println("33) hashmapObj.get="+hashmapObj.get(new KeyTest("Ganesh")));
		System.out.println("-------------------");
		
		KeyTest keyTestObj2 = new KeyTest("Shambhu");
		hashmapObj.put(keyTestObj2, "Shambhu Test"); // Adding new Value
		System.out.println("4) hashmapObj.get="+hashmapObj.get(keyTestObj2));
		
		KeyTest keyTestObj3 = keyTestObj2;
		keyTestObj2 = null;
		System.out.println("5) hashmapObj.get="+hashmapObj.get(keyTestObj2));
		System.out.println("6) hashmapObj.get="+hashmapObj.get(keyTestObj3));
		
		KeyTest keyTestObj4 = keyTestObj3;
		hashmapObj.put(keyTestObj4, "Shambhu Test new Value"); // Adding new Value
		System.out.println("7) hashmapObj.get="+hashmapObj.get(keyTestObj3));
		System.out.println("8) hashmapObj.get="+hashmapObj.get(keyTestObj4));
		System.out.println("9) hashmapObj.size()="+hashmapObj.size());
		
	}

}

class KeyTest
{
	private String keyName;
	
	public KeyTest(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public int hashCode() {
		return keyName.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		KeyTest keyTestTemp = (KeyTest)object;
		return this.keyName.equals(keyTestTemp.keyName);
	}
	
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	@Override
	public String toString() {
		return keyName;
	}

}
