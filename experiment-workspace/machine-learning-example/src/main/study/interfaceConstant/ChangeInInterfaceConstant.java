package main.study.interfaceConstant;

public class ChangeInInterfaceConstant {

	public static void main(String[] args) {
		TestInterface_1 inf = null;
		System.out.println(inf.DIRECTION);
		
		TestInterface_2 inf2 = null;
		System.out.println(inf2.DIRECTION);
		
	}

	private static interface TestInterface_1 {
		public String DIRECTION="NORTH"; 
	}
	
	private static interface TestInterface_2 {
		public String DIRECTION= "NORTH "+new DirectionUtility().getDirectionNumber();
		
		public static class DirectionUtility {
		
			public String getDirectionNumber() {
				return ""+Math.random();
			}
		}
	}
}
