# Longest Substring Without Repeating Characters

**Question:** 

Given a string, find the length of the **longest substring** without repeating characters.

**Example:** 

Given `"abcabcbb"` , the answer is `"abc"` , which the length is 3.

Given `"bbbbb"` , the answer is `"b"` , with the length of 1.

Given `"pwwkew"` , the answer is `"wke"` , with the length of 3. Note that the answer must be a **substring**, `"pwke"` is a *subsequence* and not a substring.

**Solution:** 

```java
	public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
      	// i and j are boundaries of the window. (j = i initially)
      	for(int i=0, j=0; j<s.length(); j++){
            if(map.containsKey(s.charAt(j))){
              	// when the character with index j exists in HashMap,
              	// move i to (j+1) directly
                i = Math.max(map.get(s.charAt(j)), i);
            }
            answer = Math.max(answer, j - i + 1);
          	// add the character as key and index+1 as value to the HashMap
          	// (j+1) used for i to move to.
            map.put(s.charAt(j), j+1);
        }
        return answer;
	}
```

Time Complexity: **O(n)** 

Space Complexity: **O(min(m, n))** . m is the size of charset/alphabet.

**Note:** 

Sliding Windows Algorithm is an abstract concept usually used in array and string problems. A window is a range of elements in the array/string which usually defined by the start and end indexes. i.e. [i, j). A sliding window is a window "slides" its two boundaries to the certain direction. If we slide [i, j) to the right by one, then it becomes [i+1, j+1).