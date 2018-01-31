# Longest Palindromic Substring

**Question:** 

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example:** 

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

```
Input: "cbbd"
Output: "bb"
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/LongestPalindromicSubstring.java)]

```java
public class Solution {
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
}
```

Time Complexity: **O(n<sup>2</sup>)** 

Space Complexity: **O(1)** 

**Note: **

A palindromic string can be expand from its center and there are 2n-1 such centers (for both odd and even cases).

When P(i, j) is a palindromic string and S<sub>i+1</sub> equals to S<sub>j-1</sub>, then p(i+1, j-1) is a palindromic string.

***p(i, j): the substring form i to j is a palindromic string.*** 

***S<sub>i+1</sub>: The character at i+1 index of string S.*** 