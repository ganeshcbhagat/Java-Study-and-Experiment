package main;

public class InnerExtendOuterClass {
	
	public static void main(String[] args) {
		
        Outer o = new InnerExtendOuterClass().new Outer();
        System.out.println("----------------");
        Outer.Inner1 i1 = o.new Inner1();
        System.out.println("----------------");
        Outer.Inner1.Inner2 i2 = i1.new Inner2();
        System.out.println("----------------");
	}
	
class Outer {
		
		public Outer() {
			System.out.println("Outer");
		}
		
		class Inner1 extends Outer {
			public Inner1() {
				super();
				System.out.println("Inner 1");
			}
		}
		
		 class Inner2 extends Inner1 {
			public Inner2() {
				Outer.this.super();
				System.out.println("Inner 2");
			}
		}
		
	}
	
}
