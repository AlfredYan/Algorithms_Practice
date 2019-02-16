
public class MultiplyStrings {

	public String multiplyStrings(String num1, String num2) {
		int size1 = num1.length(), size2 = num2.length();
		int[] answer = new int[size1 + size2];
		
		/*
		 * Start from right to left, perform multiplication on every pair of digits,
		 * and add them together.
		 */
		for(int i=size1-1; i>=0; i--) {
			int val1 = num1.charAt(i) - '0';
			for(int j=size2-1; j>=0; j--) {
				int val2 = num2.charAt(j) - '0';
				// digit1 is high and digit2 is low
				int digit1 = i+j;
				int digit2 = i+j+1;
				
				int val = val1 * val2 + answer[digit2];
				// assign value for low digit
				answer[digit2] = val % 10;
				// calculate the carry
				answer[digit1] += val / 10;
			}
		}
		
		// convert integer to string
		StringBuilder result = new StringBuilder();
		for(int i=0; i<answer.length; i++) {
			// remove useless 0
			if(result.length() == 0 && answer[i] == 0) continue;
			result.append(answer[i]);
		}
		
		return result.length() == 0 ? "0" : result.toString();
	}
	
	public static void main(String[] args) {
		MultiplyStrings demo = new MultiplyStrings();
		System.out.println(demo.multiplyStrings("2", "3"));
		System.out.println(demo.multiplyStrings("123", "456"));
	}
}
