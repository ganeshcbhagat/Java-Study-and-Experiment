package main.study.enumTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericEnum {

	public static void main(String[] args) {

		Direction n = Direction.NORTH;
		n.printStack();
		
		Direction e = Direction.EAST;
		e.printStack();
		
		Direction w = Direction.WEST;
		w.printStack();
		
		Direction s = Direction.SOUTH;
		s.printStack();
		
	}
	
	//you can not make genric enumeration using core java api 
	/*static private enum Direction<T> { }*/
	
	static private enum Direction {
		NORTH(1,2,3,4),
		EAST(new Person("ganesh","bhagat"),new Person("rajesh","bhagat")),
		WEST(3.12F,2.3F),
		SOUTH("50", "ganesh");
		
		private List<?> list;
		
		private <T> Direction(T ...args) {
			//list = Arrays.asList(args);
			//list = new ArrayList<T>();
			//list.addAll(Arrays.asList(args)); // compiler error
			//The List returned by Arrays.asList is java.util.Arrays.ArrayList not java.util.List so above unable to use addAll
			list = new ArrayList<T>(Arrays.asList(args));

		}

		public <T> List<T> getList() {
			return (List<T>) list;
		}
		
		public void printStack() {
			System.out.println(list);
		}
	}
	
	static class Person {
		private String firstName;
		private String lastName;
		public Person(String firstName, String lastName) {
			this.firstName=firstName;
			this.lastName=lastName;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Person [firstName=");
			builder.append(firstName);
			builder.append(", lastName=");
			builder.append(lastName);
			builder.append("]");
			return builder.toString();
		}
		
	}
}
