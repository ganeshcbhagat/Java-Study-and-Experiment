package main;

public class StringEqual {

	public static void main(String[] args) {

		String str1="hello";
		String str2=new String("hello");
		String str3=str1;
		String str4=str2;
		String str5="hel";
		String str6="hello";
		
		if(str1==str2) {System.out.println("True str1==str2");}
		else {System.out.println("False str1==str2");}

		if(str1==str6) {System.out.println("True str1==str6");}
		else {System.out.println("False str1==str6");}
		
		if(str1==str3) {System.out.println("True str1==str3");}
		else {System.out.println("False str1==str3");}
		
		if(str2==str4) {System.out.println("True str2==str4");}
		else {System.out.println("False str2==str4");}
		
		if(str1==str5+"lo") {System.out.println("True str1==str5+'lo'");}
		else {System.out.println("False str1==str5+'lo'");}
		
		if(str2==str5+"lo") {System.out.println("True str2==str5+'lo'");}
		else {System.out.println("False str2==str5+'lo'");}
		
		if(str1==str2.intern()) {System.out.println("True str1==str2.intern()");}
		else {System.out.println("False str1==str2.intern()");}
		
		if(str1==(str5+"lo").intern()) {System.out.println("True str1==(str5+'lo').intern()");}
		else {System.out.println("False str1==(str5+'lo').intern()");}
		
	}

}
