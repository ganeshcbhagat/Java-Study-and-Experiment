package main;

import java.util.AbstractList;
import java.util.ArrayList;

public class ReadOnlyCollection {

	public static void main(String[] args){
		
		ArrayList<String> listOfString = new ArrayList<String>();
		listOfString.add("String 1");
		listOfString.add("String 2");
		listOfString.add("String 3");
		listOfString.add("String 4");
		listOfString.add("String 5");
		// till now listOfEmployee is mutable
		
		ImmutableListUtility immutableListUtility = new ImmutableListUtility();
		ImmutableList immutableList = immutableListUtility.getImmutableList(listOfString);
		System.out.println(immutableList.size());

		immutableList.add("String 6"); //will throw java.lang.UnsupportedOperationException
		// immutableList.remove(2); //will throw java.lang.UnsupportedOperationException
		// immutableList.clear(); //will throw java.lang.UnsupportedOperationException

		System.out.println("End");
	}

	public static class ImmutableList extends AbstractList<String> {
		private ArrayList<String> list;
		public ImmutableList(ArrayList<String> list) {
			this.list = list;
		}

		@Override
		public String get(int i) {
			return this.list.get(i);
		}

		@Override
		public int size() {
			return this.list.size();
		}
	}

	public static class ImmutableListUtility {

		public ImmutableList getImmutableList(ArrayList<String> employeeList) {
			return new ImmutableList(employeeList);
		}
	}

}