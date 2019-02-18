package main;

public class BinaryDivide {

	float product=1,multiplier=2,a=1;
	int steps=0;
	
	public static void main(String[] args)
	{
		//System.out.println(binaryDivide(100,20));
		
		BinaryDivide binaryDivideObj = new BinaryDivide();
		System.out.println(binaryDivideObj.divide(10,3));
		//System.out.println(binaryDivideObj.binaryDivide(10,3));
	}

	private int binaryDivide(int dividend, int divisor) {
	    int current = 1;
	    int denom = divisor;
	    // This step is required to find the biggest current number which can be divided with the number safely.
	    while (denom <= dividend) {
	        current <<= 1;
	        denom <<= 1;
	    }
	    // Since we may have increased the denomitor more than dividend thus we need to go back one shift, and same would apply for current.
	    denom >>= 1;
	    current >>= 1;
	    int answer = 0;
	    // Now deal with the smaller number.
	    while (current != 0) {
	        if (dividend >= denom) {
	            dividend -= denom;
	            answer |= current;
	        }
	        current >>= 1;
	        denom >>= 1;
	    }
	    return answer;
	}
	
	private void divCore(float number, float divideBy,float lastDivison)
	{
	    steps++;
	    //epsilon check e.g (10/3) will never ends
	    if(number - divideBy < 0.01)
	        return;
	    else
	    {
	        lastDivison = divideBy; 
	        divideBy *= multiplier;
	        if(number >= divideBy)
	        {
	            product *= multiplier;
	            divCore(number,divideBy,lastDivison);
	        }
	        else
	        {
	            a *= 0.5;
	            multiplier = 1 + a;
	            divCore(number,lastDivison,lastDivison);
	        }
	    }
	}

	private float divide(float numerator, float denominator)
	{
	    //init data
	    int neg=(numerator<0)?-1:1;
	    neg*=(denominator<0)?-1:1;
	    product = 1;
	    multiplier = 2;
	    a = 1;
	    steps = 0;
	    divCore(Math.abs(numerator),Math.abs(denominator),0);
	    return product*neg;
	}
}
