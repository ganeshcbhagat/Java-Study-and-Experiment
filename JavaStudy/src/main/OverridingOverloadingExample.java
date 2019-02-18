package main;

public class OverridingOverloadingExample {

	public static void main(String[] args) {
		
		ParentChildClass p = new TestChildClass();
		p.printMethod();
		System.out.println("Value of id = "+p.id); // field id is belong to Parent class
		
		TestChildClass c = new TestChildClass();
		c.printMethod();
		System.out.println("Value of id = "+c.id); // field id is belong to child class
		
	}

}

class ParentChildClass {
	
	public int id=100;
	
	public void printMethod() {
		System.out.println("ParentChildClass: <printMethod> id="+id);
	}
}

class TestChildClass extends ParentChildClass {
	
	//Fields are not get overridden they hide the super class field 
	public int id=200;
	
	@Override
	public void printMethod() {
		//	super.printMethod();
		System.out.println("TestChildClass: <printMethod> id="+id);
	}
	
	//Override is not allowed if we are changing access modifier
	/*@Override
	private void printMethod() {
		//	super.printMethod();
		System.out.println("TestChildClass: <printMethod> id="+id);
	}*/

	//Override is not allowed if we are adding static modifier
	/*@Override
	public static void printMethod() {
		//	super.printMethod();
		System.out.println("TestChildClass: <printMethod> id="+id);
	}*/
	
	//Override is not allowed if we are throwing the exception
/*	@Override
	public void printMethod() throws Expcetion {
		System.out.println("TestChildClass: <printMethod> id="+id);
	}*/
	
	//Override is not allowed if we change the return type
	/*@Override
	public int printMethod() {
		//	super.printMethod();
		System.out.println("TestChildClass: <printMethod> id="+id);
		return 0;
	}*/
	
	
}
