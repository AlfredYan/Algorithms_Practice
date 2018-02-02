# ZigZag Conversion

**Question:** 

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this:

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: 

```
"PAHNAPLSIIGYIR"
```

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string text, int nRows);
```

**Example:** 

`convert("PAYPALISHIRING", 3)` should return `"PAHNAPLSIIGYIR"`.

**Solution:** 

```java
	public String convert(String s, int numRows) {
        StringBuffer[] result = new StringBuffer[numRows];
        char[] chars = s.toCharArray();
        int sLen = s.length();
        // create StringBuffer for each row
        for(int i=0; i<result.length; i++) {
        		result[i] = new StringBuffer();
        }
        int currPosition = 0;
        while(currPosition < sLen) {
        		// vertically down
        		for(int index=0; index<numRows && currPosition<sLen; index++) {
        			result[index].append(chars[currPosition++]);
        		}
        		// obliquely up
        		for(int index=numRows-2; index>=1 && currPosition<sLen; index--) {
        			result[index].append(chars[currPosition++]);
        		}
        }
        // join the second and third lines to the first line
        for(int index=1; index<result.length; index++) {
        		result[0].append(result[index]);
        }
        return result[0].toString();
    }
```

Time Complexity: **O(n)** 

Space Complexity: **O(n)**

