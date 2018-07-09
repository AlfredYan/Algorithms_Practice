
public class DivideTwoIntegers {
	public int divideTwoIntegers(int dividend, int divisor) {
		
		// handle overflow
		if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
		
		// determine sign
		int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
		long lDividend = Math.abs((long)dividend);
		long lDivisor = Math.abs((long)divisor);
		int result = 0;
		
		while(lDividend >= lDivisor) {
			long temp = lDivisor;
			long multiple = 1;
			// << means multiple divisor by 2
			while(lDividend > (temp << 1)) {
				temp <<= 1;
				multiple <<= 1;
			}
			lDividend -= temp;
			result += multiple;
		}
		
		return sign*result;
	}
	
	public static void main(String[] args) {
		DivideTwoIntegers demo = new DivideTwoIntegers();
		System.out.println(demo.divideTwoIntegers(10, 3));
		System.out.println(demo.divideTwoIntegers(7, -3));
	}
}
