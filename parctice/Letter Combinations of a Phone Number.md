# Letter Combinations of a Phone Number

**Question:** 

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

**Example:** 

```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/LetterCombinationsOfPhoneNumber.java)]

```java
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
```

Time Complexity: **O(k<sup>n</sup>)** , where k is the average number of the letters for each digit.

Space Complexity: **O(1)** 