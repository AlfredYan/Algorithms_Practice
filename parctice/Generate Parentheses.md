# Generate Parentheses

**Question:** 

Given *n* pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

**Example:** 

```
// Given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/GenerateParentheses.java)] 

```java
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
```

Time Complexity: **O($\frac{n^4}{\sqrt{n}}$)**. Each valid sequence has at most `n` steps during the backtracking procedure.

Space Complexity: **O($\frac{n^4}{\sqrt{n}}$)** 