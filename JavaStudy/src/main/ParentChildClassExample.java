package main;

public class ParentChildClassExample {

	public static void main(String args[]) {
		/*Child_X p = (Child_X) new Parent_X();*/
		/*In parent constructor
		In parent display method
		Exception in thread "main" java.lang.ClassCastException: main.Parent_X cannot be cast to main.Child_X
			at main.ParentChildClassExample.main(ParentChildClassExample.java:6)
			*/
		Parent_X p = new Child_X();
		p.display();

	}
}

class Parent_X {
	public Parent_X() {
		System.out.println("In parent constructor");
		display();
	}
	
	public void display() {
		System.out.println("In parent display method");
	}
}

class Child_X extends Parent_X {
	public Child_X() {
		//super(); // no impact in the output
		System.out.println("In child constructor");
		super.display();
		display();
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("In child display method");
	}
}