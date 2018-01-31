
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		// expand the palindromic substring from center
		for(int center=0; center<s.length(); center++) {
			// odd case, like "aba"
			int lenInOddCase = expandAroundCenter(s, center, center);
			// even case, like "abba"
			int lenInEvenCase = expandAroundCenter(s, center, center+1);
			int len = Math.max(lenInOddCase, lenInEvenCase);
			if(len > end - start) {
				start = center - (len - 1)/2;
				end = center + len/2;
			}
		}
	    return s.substring(start, end+1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		// if each pair of characters is the same, test from the center
		while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
	    return right - left - 1;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring demo = new LongestPalindromicSubstring();
		System.out.println(demo.longestPalindrome("babad"));;
	}
}
