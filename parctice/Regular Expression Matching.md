# Regular Expression Matching

**Question:** 

Implement regular expression matching with support for `'.'` and `'*'`.

`'.'` Matches any single character.
`'*'` Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

**Example:** 

```
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/RegularExpressionMatching.java)]

```java
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
			// ignore the preceding part of the '*' 
          	// or delete a matching character in the text
			return isMatch(text, pattern.substring(2)) || 
					(firstMatch && isMatch(text.substring(1), pattern));
		}else {
			// check next character of text and pattern
			return isMatch(text.substring(1), pattern.substring(1));
		}
		
    }
```

T, P are the lengths of text and pattern:

Time Complexity: **O((T+P)2<sup>T+p/2</sup>)** 

Space Complexity: **O((T+P)2<sup>T+p/2</sup>)** 

**Note:** 

If there were no Kleene stars(``*``), we simply check from left to right if each character of the text matches the pattern.

If a star is present in the pattern, it will be in the second position ``pattern[1]``. Then, we may ignore this part of the pattern, or delete a matching character in the text. If we have a match on the remaining strings after any of these operations, then the initial inputs matched. 