import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParentheses(int n){
		List<String> result = new ArrayList<String>();
		helper("", 0, 0, n, result);
		return result;
	}
	
	public void helper(String currString, int open, int close, int max, List<String> result) {
		if(currString.length() == 2 * max) {
			result.add(currString);
			return;
		}
		
		/**
		 * Only add them when it will remain a valid sequence
		 * Tracking the number of open and close brackets we have placed so far
		 */
		
		if(open < max) {
			helper(currString+"(", open+1, close, max, result);
		}
		
		// close is large than open, it will not valid
		if(close < open) {
			// start a closing bracket if it not exceed the number of opening brackets
			helper(currString+")", open, close+1, max, result);
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses demo = new GenerateParentheses();
		for(String s : demo.generateParentheses(3)) {
			System.out.println(s);
		}
	}
}
