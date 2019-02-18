package main;

import java.util.ArrayList;
import java.util.List;

public class EnumExtension2 {

	public static void main(String[] args) {
		Day<WeekDay> wds = WeekDay.MON;
		Day<WeekendDay> wends = WeekendDay.SUN;

		switch(wds.valueOf()){
		    case MON:
		    case TUE:
		    case WED:
		    case THU:
		    case FRI:
		}

		switch(wends.valueOf()){
		    case SAT:
		    case SUN:
		}
		
		List<Day<?>> li = new ArrayList<Day<?>>();
		li.add(WeekDay.MON);
		li.add(WeekendDay.SAT);
		li.add(WeekendDay.SUN);
		li.add(WeekDay.FRI);
		
		for(Day<?> d : li) {
			d.valueOf();
		}
		
		System.out.println("---------------------------");
		
		// This method accept Weekday as well as WeekendDay 
		testMethod1(WeekDay.FRI);
		testMethod1(WeekendDay.SUN);
		
		System.out.println("---------------------------");
		
		testMethod2(WeekDay.FRI);
		testMethod2(WeekendDay.SUN);
	}

	private static <T extends Enum<T> & Day<?>> void testMethod1(T clazz) {
		for(Enum<?> day: clazz.getClass().getEnumConstants()) {
			Day<?> dayEnum = (Day<?>) day;
			dayEnum.valueOf();
		}
	}
    
	private static void testMethod2(Day<?> day) {
		day.valueOf();
	}
	
	private static interface Day<T extends Day<T>> {
		public T valueOf();
	}

	private static enum WeekDay implements Day<WeekDay> {
	    MON, TUE, WED, THU, FRI;
		public WeekDay valueOf(){
		 System.out.println("Name: "+name());
	     return valueOf(name());
	   }
	}

	private static enum WeekendDay implements Day<WeekendDay> {
	    SAT, SUN;
	   public WeekendDay valueOf(){
		 System.out.println("Name: "+name());
	     return valueOf(name());
	   }
	}
	
	
}
