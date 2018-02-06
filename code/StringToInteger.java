
public class StringToInteger {
	public int stringToInteger(String str) {
		// str is not correct
		if(str == null || str.length() == 0) return 0;
		// remove start and end space of str
		str = str.trim();
		int sign = 1, start = 0;
		// use long type to handle int overflow issue
		long sum = 0;
		char currChar, charZero = '0';
		char firstChar = str.charAt(0);
		if(firstChar == '-') {
			sign = -1;
			start++;
		}else if(firstChar == '+') {
			start++;
		}
		for(; start<str.length(); start++) {
			currChar = str.charAt(start);
			// when the char is not a number, return the sum
			if(!Character.isDigit(currChar)) return sign*(int)sum;
			sum = sum*10 + currChar - charZero;
			// overflow issue
			if(sum > Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
			else if((-1)*sum < Integer.MIN_VALUE && sign == -1) return Integer.MIN_VALUE;
		}
		return sign*(int)sum;
	}
	
	public static void main(String[] args) {
		StringToInteger demo = new StringToInteger();
		System.out.println(demo.stringToInteger(""));
		System.out.println(demo.stringToInteger("2147483648"));
		System.out.println(demo.stringToInteger("-2147483649"));
		System.out.println(demo.stringToInteger("  -0012a42"));
	}
}
