package main.study.generic;

import java.util.Collection;
import java.util.List;

public class CyclicGeneric {

	public static void main(String[] args) {

		/*CyclicTest2 t1 = new CyclicTest2<List<String>,List<List<String>>>();
		t1.print();*/
		
		/*CyclicTest2 t2 = new CyclicTest2<?,?>();
		t2.print();*/
		
		/*CyclicTest2 t3 = new CyclicTest2();
		t3.print();*/
	}

	
	//Cyclic type parameter so compile time error
	/*static class CyclicTest1<T extends R, R extends T> {
		public void print(T t ) {
			System.out.println("print "+t);
		}
	}*/
	
	//Useless below class
	/*static class CyclicTest2<T extends R, R extends Collection<T>> {
		public void print() {
			System.out.println("print");
		}
	}*/
}
