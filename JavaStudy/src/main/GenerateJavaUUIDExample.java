package main;

import java.util.UUID;

public class GenerateJavaUUIDExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//This class is used to generate random UUID (Universally unique identifier).
		
		UUID first = UUID.randomUUID();
        UUID second = UUID.randomUUID();
        
        System.out.println("UUID first: " + first);
        System.out.println("UUID second: " + second);

        System.out.println("UUID version: " + second.version());
        System.out.println("UUID variant: " + second.variant());
	}

}
