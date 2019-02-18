package main;

import java.util.ArrayList;

public class InheritanceInArrayList {

	public static void main(String[] args) {

		ArrayList<ParentTest1> arrayList = new ArrayList<ParentTest1>();
		arrayList.add(new ChildTest1());
		arrayList.add(new ParentTest1());
		arrayList.add(new ChildTest1());
		
		System.out.println(arrayList);
	}

	public static class ParentTest1 {
		public void printMethod() {
			System.out.println("ParentTest1: <printMethod>");
		}
		
		@Override
		public String toString() {
			return "ParentTest1";
		}
	}
	
	public static class ChildTest1 extends ParentTest1 {
		
		@Override
		public void printMethod() {
			System.out.println("ChildTest1: <printMethod>");
		}
		
		@Override
		public String toString() {
			return "ChildTest1";
		}
	}
}
