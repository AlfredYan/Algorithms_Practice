# Longest Common Prefix

**Question:** 

Write a function to find the longest common prefix string amongst an array of strings.

**Example:** 

```
Input: ["a", "a", "b"]
Output: ""
```

```
Input: ["abc", "abcde"]
Output: "abc"
```

```
Input: ["ac", "a", "a", "ac"]
Output: "a"
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/LongestCommonPrefix.java)]

```java
	public String getLongestCommonPrefix(String[] strings) {
		if(strings == null || strings.length == 0) return "";
		
		// set first string as common prefix
		String comPrefix = strings[0];
		int currPos = 1;
		while(currPos < strings.length) {
			
			// find the common prefix
			// when no common prefix, comPrefix becomes ""
			while(strings[currPos].indexOf(comPrefix) != 0)
				comPrefix = comPrefix.substring(0, comPrefix.length()-1);
			
			currPos++;
		}
		return comPrefix;
	}
```

n: Number of strings in array; k: average length of strings in array

Time Complexity: **O(nk)** 

Space Complexity: **O(1)** 