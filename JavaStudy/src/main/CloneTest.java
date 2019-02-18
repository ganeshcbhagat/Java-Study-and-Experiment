package main;

public class CloneTest {

	public static void main(String[] args) {

		CloneTestClass ob1 = new CloneTestClass("1", new XyzClass("-1"));
		CloneTestClass ob2 = ob1;
		
		if(ob1 == ob2) {
			System.out.println("ob1 == ob2");
			System.out.println(ob1+" == "+ob2);
			if(ob1.xyzClassObj == ob2.xyzClassObj) {
				System.out.println("ob1.xyzClassObj == ob2.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob2.xyzClassObj);
			} else {
				System.out.println("ob1.xyzClassObj Not ob2.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob2.xyzClassObj);
			}
		} else {
			System.out.println("ob1 Not ob2");
			System.out.println(ob1+" == "+ob2);
		}
		
		System.out.println("------------------------------");
		
		ob1.msg="2";
		ob1.xyzClassObj.xyzMsg="-2";
		
		if(ob1 == ob2) {
			System.out.println("ob1 == ob2");
			System.out.println(ob1+" == "+ob2);
			if(ob1.xyzClassObj == ob2.xyzClassObj) {
				System.out.println("ob1.xyzClassObj == ob2.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob2.xyzClassObj);
			} else {
				System.out.println("ob1.xyzClassObj Not ob2.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob2.xyzClassObj);
			}
		} else {
			System.out.println("ob1 Not ob2");
			System.out.println(ob1+" == "+ob2);
		}
		
		System.out.println("------------------------------");
		
		CloneTestClass ob3=null;
		try {
			ob3 = (CloneTestClass) ob1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		if(ob1 == ob3) {
			System.out.println("ob1 == ob3");
			System.out.println(ob1+" == "+ob3);
			if(ob1.xyzClassObj == ob3.xyzClassObj) {
				System.out.println("ob1.xyzClassObj == ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			} else {
				System.out.println("ob1.xyzClassObj Not ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			}
		} else {
			System.out.println("ob1 Not ob3");
			System.out.println(ob1+" == "+ob3);
			if(ob1.xyzClassObj == ob3.xyzClassObj) {
				System.out.println("ob1.xyzClassObj == ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			} else {
				System.out.println("ob1.xyzClassObj Not ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			}
		}
		
		System.out.println("------------------------------");
		
		ob1.msg="3";
		ob1.xyzClassObj.xyzMsg="-3";
		
		if(ob1 == ob3) {
			System.out.println("ob1 == ob3");
			System.out.println(ob1+" == "+ob3);
			if(ob1.xyzClassObj == ob3.xyzClassObj) {
				System.out.println("ob1.xyzClassObj == ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			} else {
				System.out.println("ob1.xyzClassObj Not ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			}
		} else {
			System.out.println("ob1 Not ob3");
			System.out.println(ob1+" == "+ob3);
			if(ob1.xyzClassObj == ob3.xyzClassObj) {
				System.out.println("ob1.xyzClassObj == ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			} else {
				System.out.println("ob1.xyzClassObj Not ob3.xyzClassObj");
				System.out.println(ob1.xyzClassObj+" == "+ob3.xyzClassObj);
			}
		}
		
		System.out.println("------------------------------");
	}
	   
	static class CloneTestClass implements Cloneable {
	//static class CloneTestClass {
		
		public String msg; 
		public XyzClass xyzClassObj;
		
		public CloneTestClass(String msg, XyzClass xyzClassObj) {
			this.msg = msg;
			this.xyzClassObj = xyzClassObj;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			CloneTestClass temp = (CloneTestClass) super.clone();
			temp.xyzClassObj = (XyzClass) this.xyzClassObj.clone();
			return temp;
			//return super.clone();
		}
		
		@Override
		public String toString() {
			return "msg:"+msg+" xyzMsg:"+(xyzClassObj==null? "null" : xyzClassObj.xyzMsg);
		}
	}
	
	static class XyzClass implements Cloneable {
	/*static class XyzClass {*/
		public String xyzMsg;
		
		public XyzClass(String xyzMsg) {
			this.xyzMsg = xyzMsg;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
		
		@Override
		public String toString() {
			return "xyzMsg:"+xyzMsg;
		}
	}
}
