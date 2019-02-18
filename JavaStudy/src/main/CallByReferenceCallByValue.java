package main;

public class CallByReferenceCallByValue {

	public static void main(String[] args) {

		int x=5;
		System.out.println("Before x="+x);
		callByReferenceInt(x);
		System.out.println("After x="+x);
		
		int array[]={250,2,3};
		System.out.println("Before First Element="+array[0]);
		callByReference(array);
		System.out.println("After First Element="+array[0]);
		
		TestClassX testClass = new TestClassX();
		testClass.setStr("hello");
		System.out.println("Before testClass str="+testClass.getStr());
		callByReferenceObj_1(testClass);
		System.out.println("After testClass str="+testClass.getStr());
		
		System.out.println("Before testClass is null="+(testClass==null? true: false));
		callByReferenceObj_2(testClass);
		System.out.println("After testClass is null="+(testClass==null? true: false));
	}

	public static void callByReferenceInt(final int x) {
		//x=5; //Unresolved compilation problem:, The final local variable x cannot be assigned. It must be blank and not using a compound assignment
	}
	
	public static void callByReference(final int array[]) {
		array[0]=10; //Change in the original array element value
		//array = null; //Unresolved compilation problem:, The final local variable array cannot be assigned. It must be blank and not using a compound assignment
	}
	
	public static void callByReferenceObj_1(final TestClassX testClass) {
		testClass.setStr("hello Ganesh"); //Change in the original array element value
		//testClass = null; //Unresolved compilation problem:, The final local variable array cannot be assigned. It must be blank and not using a compound assignment
		//testClass.setStr("hello Ganesh"); //Change in the original array element value
	}
	
	public static void callByReferenceObj_2(TestClassX testClass1) {
		testClass1 = null;
	}
}

class TestClassX {
	
	private String Str;

	public String getStr() {
		return Str;
	}

	public void setStr(String str) {
		Str = str;
	}
	

}