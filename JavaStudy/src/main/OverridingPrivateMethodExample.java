package main;

public class OverridingPrivateMethodExample {

	public static void main(String[] args) {
		//BottomClass top = new BottomClass();
		/*TopClass top = new BottomClass();
		top.privateMethod();*/
		
		Top.main(null);
	}

}

class Top {
	
	public static void main(String[] args) {
		Top topRef = new Bottom();
		topRef.privateMethod();
		topRef.privateStaticMethod();
		
		Top topRef1 = null;
		topRef1.privateStaticMethod(); // even topRef1 = null it will print 'Top => privateStaticMethod'
		
		Bottom bottomRef = new Bottom();
		//bottomRef.privateMethod(); //As method is private so you can not call outside of Bottom class.
		//bottomRef.privateStaticMethod(); //As method is private so you can not call outside of Bottom class.
	}

	private void privateMethod() {
		System.out.println("Top => privateMethod");
	}

	private static void privateStaticMethod() {
		System.out.println("Top => privateStaticMethod");
	}
}

class Bottom extends Top {
	
	//@Override // do not put the Override annotation 
	private void privateMethod() {
		//	super.privateMethod();
		System.out.println("Bottom => privateMethod");
	}
	
	//@Override // do not put the Override annotation
	private static void privateStaticMethod() {
		System.out.println("Bottom => privateStaticMethod");
	}

}
