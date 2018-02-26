import java.util.HashMap;

public class RomanToInteger {
	public int romanToInteger(String roman) {
		HashMap<Character, Integer> romanVal = new HashMap<Character, Integer>();
		romanVal.put('M', 1000);
		romanVal.put('D', 500);
		romanVal.put('C', 100);
		romanVal.put('L', 50);
		romanVal.put('X', 10);
		romanVal.put('V', 5);
		romanVal.put('I', 1);
		
		char currChar;
		int currPos = 0, sum = 0, currVal = 0, preVal = 0;
		while(currPos < roman.length()) {
			currChar = roman.charAt(currPos);
			currVal = romanVal.get(currChar);
			if(currVal > preVal) {
				// when this happens, it means the previous char should be subtracted
				// like IV, IX, XL, XC, CD, CM
				sum -= preVal*2;
			}
			sum += currVal;
			preVal = currVal;
			currPos++;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		RomanToInteger demo = new RomanToInteger();
		System.out.println(demo.romanToInteger("VII"));
		System.out.println(demo.romanToInteger("XX"));
		System.out.println(demo.romanToInteger("CCCLXV"));
		System.out.println(demo.romanToInteger("MCCXXXIV"));
		System.out.println(demo.romanToInteger("MMMCMXCIX"));
	}
}
