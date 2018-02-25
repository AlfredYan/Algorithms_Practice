# Integer to Roman

**Question:** 

Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

**Example:** 

```
Input: 7
Output: VII
```

```
Input: 365
Output: CCCLXV
```

```
Input: 3999
Output: MMMCMXCIX
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/IntegerToRoman.java)]

```java
	String thousands[] = {"", "M", "MM", "MMM"};
    String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String bits[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	
	public String integerToRoman(int number) {
		if(number >=1 && number <= 3999)
			return thousands[number / 1000] + hundreds[(number % 1000) / 100] + 
						tens[(number % 100) / 10] + bits[(number % 10)];
		else
			return "Out of Range";
	}
```

Time Complexity: **O(1)** 

Space Complexity: **O(1)** 