
public class RegularExpressionMatching {
	
	public boolean isMatch(String text, String pattern) {
		// when the pattern is empty, the text has to be empty
		if(pattern.isEmpty()) return text.isEmpty();
		
		// when the text is not empty
		// the first character should be the same 
		// or pattern's first character should be '.'  
		boolean firstMatch = (!text.isEmpty() && 
						(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
		
		if(pattern.length() >= 2 && pattern.charAt(1) == '*') {
			// if the second character of pattern is '*'
			// ignore the preceding part of the '*' or delete a matching character in the text
			return isMatch(text, pattern.substring(2)) || 
					(firstMatch && isMatch(text.substring(1), pattern));
		}else {
			// check next character of text and pattern
			return isMatch(text.substring(1), pattern.substring(1));
		}
		
    }
	
	public static void main(String[] args) {
		RegularExpressionMatching demo = new RegularExpressionMatching();
		System.out.println(demo.isMatch("aa","a"));
		System.out.println(demo.isMatch("aab", "c*a*b"));
		System.out.println(demo.isMatch("aa","aa"));
		System.out.println(demo.isMatch("aaa","aa"));
		System.out.println(demo.isMatch("aa","a*"));
		System.out.println(demo.isMatch("aa",".*"));
		System.out.println(demo.isMatch("ab",".*"));
	}
}
