# Roman to Integer

**Question:** 

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

**Example:** 

```
Input: VII
Output: 7
```

```
Input: CCCLXV
Output: 365
```

```
Input: MMMCMXCIX
Output: 3999
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/RomanToInteger.java)]

```java
	import java.util.HashMap;
	public int romanToInteger(String roman) {
		HashMap<Character, Integer> romanVal = new HashMap<Character, Integer>();
		romanVal.put('M', 1000);
		romanVal.put('D', 500);
		romanVal.put('C', 100);
		romanVal.put('L', 50);
		romanVal.put('X', 10);
		romanVal.put('V', 5);
		romanVal.put('I', 1);
		
		char currChar;
		int currPos = 0, sum = 0, currVal = 0, preVal = 0;
		while(currPos < roman.length()) {
			currChar = roman.charAt(currPos);
			currVal = romanVal.get(currChar);
			if(currVal > preVal) {
				// when this happens, it means the previous char should be subtracted
				// like IV, IX, XL, XC, CD, CM
				sum -= preVal*2;
			}
			sum += currVal;
			preVal = currVal;
			currPos++;
		}
		
		return sum;
	}
```

Time Complexity: **O(n)** 

Space Complexity: **O(1)** 