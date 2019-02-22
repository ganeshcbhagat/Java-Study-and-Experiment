package main.study.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericArray<T> {

	private T testArray[];
	
	public static void main(String[] args) {

		//you can not create an array of specific type generic collection or normally
		//Because at runtime the type specific information is lost and type parameter is converted to an Object class
		//by using wild card character ? you can create an array of it.

		//1) List<Integer> arrayOfIdList[] = new ArrayList<Integer>[10];
		
		//2) GenericArray ob = new  GenericArray();
		//ob.testArray = new T [2];
		
		List<?> arrayOfIdList[] = new ArrayList<?>[2];
		//----------------------------------------------------------------------------------
		
		List<String> nameList = new ArrayList<String>() {
			@Override
			public String toString() {
				return "String List:"+super.toString();
			}
		};
		
		nameList.add("hello");
		nameList.add("generic");
		nameList.add("world");
		//----------------------------------------------------------------------------------
		
		List<Integer> numberList = new ArrayList<Integer>() {
			@Override
			public String toString() {
				return "Integer List:"+super.toString();
			}
		};
		
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		//----------------------------------------------------------------------------------
		
		Object objArray[] = arrayOfIdList;
		objArray[0] = nameList;
		objArray[1] = numberList;
		//Object id = objArray[0].get(0);
		
		System.out.println(Arrays.deepToString(objArray));
		
	}

}
