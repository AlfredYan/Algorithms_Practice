# String to Integer (atoi)

**Question:** 

Implement *atoi* to convert a string to an integer. Convert the characters until meet the character that cannot cast to number.

*Notes:* It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

**Example:** 

```
Input: ""
Output: 0
```

```
Input: "  -0012a42"
Output: -12
```

```
Input: "-2147483649"
Output: -2147483648
```

```
Input: "2147483648"
Output: 2147483647
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/StringToInteger.java)]

```java
	public int stringToInteger(String str) {
		// str is not correct
		if(str == null || str.length() == 0) return 0;
		// remove start and end space of str
		str = str.trim();
		int sign = 1, start = 0;
		// use long type to handle int overflow issue
		long sum = 0;
		char currChar, charZero = '0';
		char firstChar = str.charAt(0);
		if(firstChar == '-') {
			sign = -1;
			start++;
		}else if(firstChar == '+') {
			start++;
		}
		for(; start<str.length(); start++) {
			currChar = str.charAt(start);
			// when the char is not a number, return the sum
			if(!Character.isDigit(currChar)) return sign*(int)sum;
			sum = sum*10 + currChar - charZero;
			// overflow issue
			if(sum > Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
			else if((-1)*sum < Integer.MIN_VALUE && sign == -1) return Integer.MIN_VALUE;
		}
		return sign*(int)sum;
	}
```

