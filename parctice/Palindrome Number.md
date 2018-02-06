# Palindrome Number

**Question:** 

Determine whether an integer is a palindrome. Do this without extra space.

**Example:** 

```
Input: 100
Output: false
```

```
Input: 1221
Output: true
```

```
Input: -5
Output: false
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/PalindromeNumber.java)]

```java
	public boolean isPalindrome(int x) {
		// return false for the following situation:
		// 1. negative numbers
		// 2. numbers that are divided by 10, except 0 (e.g. 100, 200)
		if(x<0 || (x%10==0 && x!=0)) return false;
		int reversedSecondHalf = 0;
		while(x > reversedSecondHalf) {
			reversedSecondHalf = reversedSecondHalf*10 + x%10;
			x = x/10;
		}
		
		// when the length of number is odd
      	// get rid of the middle digit by reversedSecondHalf/10
		return x == reversedSecondHalf || x == reversedSecondHalf/10;
	}
```

Time Complexity: **O(log<sub>10</sub>n)** 

Space Complexity: **O(1)** 

**Note:** 

1. Converting to string will require extra non-constant space.
2. Reverting the number may cause overflow issue.