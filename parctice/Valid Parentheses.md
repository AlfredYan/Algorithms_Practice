# Valid Parentheses

**Question:** 

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example:** 

```
// example 1
Input: "()"
Output: true

// example 2
Input: "()[]{}"
Output: true

// example 3
Input: "(]"
Output: false

// example 4
Input: "([)]"
Output: false

// example 5
Input: "{[]}"
Output: true
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ValidParentheses.java)] 

```java
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(Character c : s.toCharArray()) {
			if(c == '(') stack.push(')');
			else if(c == '[') stack.push(']');
			else if(c == '{') stack.push('}');
			else if(stack.isEmpty() || stack.pop() != c) {
				/* when we meet a type of second part parentheses, like: ), ], }
				* it should correspond to the most recent one that push to the stack,
				* otherwise the syntax is invalid
				*/
				return false;
			}
		}
		
		return stack.isEmpty();
	}
```

Time Complexity: **O(n)**, where ``n`` is the length of the input string.

Space Complexity: **O(n)**, where ``n`` is the length of the input string. 