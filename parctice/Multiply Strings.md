# Multiply Strings

**Question:** 

Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.

*Note:*

1. Both `num1` and `num2` contain only digits `0-9`.
2. Both `num1` and `num2` do not contain any leading zero, except the number 0 itself.
3. Don't use any *built-in BigInteger library* or *convert the inputs to integer* directly.

**Example:** 

```
// Example 1
Input: num1 = "2", num2 = "3"
Output: "6"

// Example 2
Input: num1 = "123", num2 = "456"
Output: "56088"
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/MultiplyStrings.java)] 

```java
	public String multiplyStrings(String num1, String num2) {
		int size1 = num1.length(), size2 = num2.length();
		int[] answer = new int[size1 + size2];
		
		/*
		 * Start from right to left, perform multiplication on every pair of digits,
		 * and add them together.
		 */
		for(int i=size1-1; i>=0; i--) {
			int val1 = num1.charAt(i) - '0';
			for(int j=size2-1; j>=0; j--) {
				int val2 = num2.charAt(j) - '0';
				// digit1 is high and digit2 is low
				int digit1 = i+j;
				int digit2 = i+j+1;
				
				int val = val1 * val2 + answer[digit2];
				// assign value for low digit
				answer[digit2] = val % 10;
				// calculate the carry
				answer[digit1] += val / 10;
			}
		}
		
		// convert integer to string
		StringBuilder result = new StringBuilder();
		for(int i=0; i<answer.length; i++) {
			// remove useless 0
			if(result.length() == 0 && answer[i] == 0) continue;
			result.append(answer[i]);
		}
		
		return result.length() == 0 ? "0" : result.toString();
	}
```

Time Complexity: ***O*(n*m)** , where `n` is the length of number 1 and `m` is the length of number 2.

Time Complexity: ***O*(n+m)** , where `n` is the length of number 1 and `m` is the length of number 2. 