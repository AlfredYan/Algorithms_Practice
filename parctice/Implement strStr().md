# Implement strStr()

**Question:** 

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack. we will return 0 when `needle` is an empty string.

**Example:** 

```
// example 1
Input: haystack = "hello", needle = "ll"
Output: 2

// example 2
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ImplementStrFun.java)] 

```java
	public int strStr(String haystack, String needle) {
		
		// some special condition
		if(haystack == null || needle == null) return -1;
		if(needle.length() == 0) return 0;
		if(haystack.length() < needle.length()) return -1;
		
		for(int i=0; i<haystack.length(); i++) {
			int haystackIndex = i;
			int needleIndex = 0;
			
			// keep comparing each character until difference occurs
			while(haystackIndex < haystack.length() && needleIndex < needle.length() 
					&& haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
				haystackIndex++;
				needleIndex++;
			}
			
			// when find the index that the needle starts
			if(needleIndex == needle.length())	return i;
		}
		
		return -1;
	}
```

Time Complexity: **O(n*m)** , where ``n`` is the length of haystack and ``m`` is the length of needle.

Space Complexity: **O(1)** 