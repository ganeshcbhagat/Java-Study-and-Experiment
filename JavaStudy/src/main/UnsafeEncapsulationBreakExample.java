package main;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeEncapsulationBreakExample {

	private static Unsafe unsafe;
	
	  static {
	        try {
	            Field field = Unsafe.class.getDeclaredField("theUnsafe");
	            field.setAccessible(true);
	            unsafe = (Unsafe)field.get(null);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		Account account = new Account();
		System.out.println("Note:" +account.getMessage());
		float minimumAmount=-10;
		
		try{
			account.openAccount(1200F);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		 try{
				account.openAccount(2);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		System.out.println("------------ Code hacking Start ------------");
		
        Field field = account.getClass().getDeclaredField("minimumAmount");
        field.setAccessible(true);
        unsafe.putFloat(account, unsafe.objectFieldOffset(field), minimumAmount);
        
        field = account.getClass().getDeclaredField("message");
        field.setAccessible(true);
        unsafe.putObject(account, unsafe.objectFieldOffset(field), "Yes Now you can open new Account by paying minimum Rs "+minimumAmount+" amount.");

        System.out.println("------------ Code hacking Done ------------");
        
        try{
			account.openAccount(2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
        
        System.out.println(account.getMessage()); 
	}

	private static class Account {
		private float minimumAmount=1000;
		private float amount=0;
		private String message="To open new account, You need to deposit Rs "+minimumAmount+" amount.";
		
		public String getMessage() {
			return message;
		}

		public void openAccount(float amount) throws Exception {
			if(amount>=minimumAmount) {
				this.amount = amount;
				System.out.println("Congratulation you! Your have open new account by Rs "+amount);
			} else {
				throw new Exception("Warning: "+getMessage());
			}
		}
	}
}
