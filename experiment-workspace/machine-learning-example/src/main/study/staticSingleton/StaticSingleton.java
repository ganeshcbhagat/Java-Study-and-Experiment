package main.study.staticSingleton;

import main.study.staticSingleton.Factory.RepositoryType;

public class StaticSingleton {

	public static void main(String[] args) {
		
		//Factory f1 = Factory.getInstance();
		Factory f1 = new Factory();
		
		Repository r1 = Factory.getRepository(RepositoryType.DATABASE);
		r1.print();
		
		//Factory f2 = Factory.getInstance();
		Factory f2 = new Factory();
		
		Repository r3 = Factory.getRepository(RepositoryType.DATABASE);
		r3.print();
		
		System.out.println(System.identityHashCode(r1));
		System.out.println(System.identityHashCode(r3));
	}
	
}
