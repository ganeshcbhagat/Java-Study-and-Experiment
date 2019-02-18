package main;

import java.util.ArrayList;

public class CombinationsOfSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getCombinations("GANESH"));
		//System.out.println(getPermutations("GANESH"));
	}

	public static ArrayList<String> getCombinations(String text) {
	    ArrayList<String> results = new ArrayList<String>();
	    for (int i = 0; i < text.length(); i++) {
	        // Record size as we will be adding to the list
	        int resultsLength = results.size();
	        for (int j = 0; j < resultsLength; j++) {
	            results.add(text.charAt(i) + results.get(j));
	            //System.out.println(results);
	        }
	        results.add(Character.toString(text.charAt(i)));
	        //System.out.println(results);
	    }
	    return results;
	}
	
	public static ArrayList<String> getPermutations(String text) {
	    ArrayList<String> results = new ArrayList<String>();

	    // the base case
	    if (text.length() == 1) {
	        results.add(text);
	        return results;
	    }

	    for (int i = 0; i < text.length(); i++) {
	        char first = text.charAt(i);
	        String remains = text.substring(0, i) + text.substring(i + 1);

	        ArrayList<String> innerPermutations = getPermutations(remains);

	        for (int j = 0; j < innerPermutations.size(); j++)
	            results.add(first + innerPermutations.get(j));
	    }

	    return results;
	}
}
