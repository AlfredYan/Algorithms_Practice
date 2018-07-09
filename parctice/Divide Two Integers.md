# Divide Two Integers

**Question:** 

------

Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing `dividend` by `divisor`. The integer division should truncate toward zero.

*Note: Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.* 

**Example:** 

```
// Example 1
Input: dividend = 10, divisor = 3
Output: 3

// Example 2
Input: dividend = 7, divisor = -3
Output: -2
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/DivideTwoIntegers.java)] 

```java
	public int divideTwoIntegers(int dividend, int divisor) {
		
		// handle overflow
		if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
		
		// determine sign
		int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
		long lDividend = Math.abs((long)dividend);
		long lDivisor = Math.abs((long)divisor);
		int result = 0;
		
		while(lDividend >= lDivisor) {
			long temp = lDivisor;
			long multiple = 1;
			// << means multiple divisor by 2
			while(lDividend > (temp << 1)) {
				temp <<= 1;
				multiple <<= 1;
			}
			lDividend -= temp;
			result += multiple;
		}
		
		return sign*result;
	}
```

Time Complexity: **O(logn)** 

Space Complexity: **O(1)** 