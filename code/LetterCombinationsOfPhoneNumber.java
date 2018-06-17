import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public List<String> letterCombinations(String digits){
		List<String> result = new ArrayList<String>();
		if(digits.length() != 0)
			helper(0, digits, "", result);
		return result;
	}
	
	public void helper(int currDigitPosition, String digits, String prefix, List<String> result) {
		if(currDigitPosition == digits.length()) {
			result.add(prefix);
			return;
		}
		int currdigit = Character.getNumericValue(digits.charAt(currDigitPosition));
		String currLetters = letters[currdigit];
		for(int i=0; i<currLetters.length(); i++) {
			helper(currDigitPosition + 1, digits, prefix + currLetters.charAt(i), result);
		}
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber demo = new LetterCombinationsOfPhoneNumber();
		System.out.println(demo.letterCombinations("234").toString());
	}
}
