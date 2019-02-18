package main;

public class StaticBlockTest {

	static {
		System.out.println("Parent Static Block");
	}
	
	public StaticBlockTest() {
		System.out.println("Parent Constructor");
	}
	
	public static void main(String[] args) {
		
		new SubStaticBlockTest();
		System.out.println("-----------------------------------");
		new StaticBlockTest();
		System.out.println("-----------------------------------");
		new SubStaticBlockTest();
	}
}

class SubStaticBlockTest extends StaticBlockTest {
	static {
		System.out.println("Child Static Block");
	}
	
	public SubStaticBlockTest() {
		System.out.println("Child Constructor");
	}
}
