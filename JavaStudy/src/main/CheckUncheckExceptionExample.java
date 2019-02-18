package main;

public class CheckUncheckExceptionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckUncheckExceptionExample obj = new CheckUncheckExceptionExample();
		obj.storeDataFromUrl("X");
		
		//In Integer class valueOf() method will always cache values in the range -128 to 127 and may cache other values outside of this range.
		System.out.println(Integer.valueOf(127) == Integer.valueOf(127));   // true
		System.out.println(Integer.valueOf(128) == Integer.valueOf(128));  //false
		
	}

	
	public void storeDataFromUrl(String url) {
		String data = null;
		
		try {
			data = readDataFromUrl(url);
		} catch (BadUrlException e) {
			e.printStackTrace();
		}
		System.out.println(data);
	}

	public String readDataFromUrl(String url) throws BadUrlException {
		if (isUrlBad(url)) {
			throw new BadUrlException("Bad URL: " + url);
		}

		String data = null;
		// read lots of data over HTTP and return it as a String instance.

		return data;
	}

	private boolean isUrlBad(String url) {
		boolean isbad =true;
		if(url.equalsIgnoreCase("x")==true) {
			isbad=false;
		}
		return isbad;
	}
	
	private class BadUrlException extends Exception {
		private static final long serialVersionUID = -680657720293334327L;

		public BadUrlException(String s) {
			super(s);
		}
	}
}
