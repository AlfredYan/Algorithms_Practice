# Reverse Integer

**Question:** 

Given a 32-bit signed integer, reverse digits of an integer. Assume that your function returns 0 when the reversed integer overflows.

**Example:** 

```
Input: 123
Output:  321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

**Solution: **[[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ReverseInteger.java)]

```java
	public int reverse(int x) {
		int result = 0;
		int newResult = 0;
		int tail = 0;
		while(x != 0) {
			// get the value of last digit
			tail = x%10;
			newResult = result*10 + tail;
			// fix overflow problem
			if((newResult - tail)/10 != result) {
				return 0;
			}
			result = newResult;
			x=x/10;
		}
		return result;
	}
```

