package main;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;
import java.net.URI;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
public class UserInputFileDemo {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        
        //int studentID;
        String subject;
        int marks;
        
        Map<String,Integer> retVal = new LinkedHashMap<String,Integer>();
        
        for (String lineStr : array) {
        
        	String recordStr = new String(lineStr);
        	String parts[] = recordStr.split("\\|"); 
    		//studentID = Integer.parseInt(parts[0]);
    		subject = parts[1];
    		marks = Integer.parseInt(parts[2]);
    		
    		if(retVal.get(subject)==null) {
    			
    			retVal.put(subject, marks);
    			
    		} else {

    			int tempMarks = retVal.get(subject);
    			if(marks<tempMarks) {
    				retVal.put(subject, marks);
    			}
    		}
    		
        }
        
       return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            
        	
        	Scanner in = new Scanner(UserInputFileDemo.class.getResourceAsStream("input.txt"));
        	
        	//Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\CEP\\input.txt")));
            
            while(in.hasNextLine()) {
                inputData.add(in.nextLine());
            }
            
            Map<String,Integer> retVal = processData(inputData);
            //PrintWriter output = new PrintWriter(UserInputFileDemo.class.getResourceAsStream("output.txt"));
            
            System.out.println(UserInputFileDemo.class.getResource("output.txt").getFile());
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(UserInputFileDemo.class.getResource("output.txt").getFile())));
            for(Map.Entry<String,Integer> e: retVal.entrySet()) {
                output.println(e.getKey() + ": " + e.getValue());
            	System.out.println(e.getKey() + ": " + e.getValue());
            }
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
