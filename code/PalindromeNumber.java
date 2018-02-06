
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		// return false for the following situation:
		// 1. negative numbers
		// 2. numbers that are divided by 10, except 0 (e.g. 100, 200)
		if(x<0 || (x%10==0 && x!=0)) return false;
		int reversedSecondHalf = 0;
		while(x > reversedSecondHalf) {
			reversedSecondHalf = reversedSecondHalf*10 + x%10;
			x = x/10;
		}
		
		// when the length of number is odd, get rid of the middle digit by reversedSecondHalf/10
		return x == reversedSecondHalf || x == reversedSecondHalf/10;
	}
	
	public static void main(String[] args) {
		PalindromeNumber demo = new PalindromeNumber();
		System.out.println(demo.isPalindrome(100));
		System.out.println(demo.isPalindrome(1221));
		System.out.println(demo.isPalindrome(-5));
	}
}
