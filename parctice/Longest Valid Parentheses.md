# Longest Valid Parentheses

**Question:** 

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

**Example:** 

```
// Example 1
Input: "(()"
Output: 2

// Example 2
Input: ")()())"
Output: 4
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/LongestValidParentheses.java)] 

1. *Dynamic Programming* 

   ```java
   	public int dpSolution(String s) {
   		// dpArray stores the length of longest valid substring ending at ith index
   		int[] dpArray = new int[s.length()];
   		int result = 0;
   		for(int i=1; i<s.length(); i++) {
   			// the parentheses may be valid only when it ends with ')'
   			if(s.charAt(i) == ')') {
   				if(s.charAt(i-1) == '(') {
   					/* 
   					 * when the previous character is '(', 
   					 * get the index which 2 smaller than it 
   					 * and get the length of its longest valid 
   					 * parentheses from dpArray, then add 2
   					 */
   					dpArray[i] = (i>=2 ? dpArray[i-2] : 0) + 2;
   				}else if(i - dpArray[i-1] > 0 && s.charAt(i-dpArray[i-1]-1) == '('){
   					/*
   					 * when the previous character is ')' and 
   					 * the character before previous valid parentheses is '('
   					 */
   					dpArray[i] = dpArray[i-1] + 
                           ((i-dpArray[i-1] >= 2) ? dpArray[i-dpArray[i-1]-2] : 0) + 2;
   				}
   			}
   			result = Math.max(result, dpArray[i]);
   		}
   		return result;
   	}
   ```

   Time Complexity: **O(n)** 

   Space Complexity: **O(n)** 

   *Note:* 

   - *Optimal substructure* means that the solution to a given optimization problem can be obtained by the combination of optimal solutions to its sub-problems.
   - *Overlapping* sub-problems means that the space of sub-problems must be small, that is, any recursive algorithm solving the problem should solve the same sub-problems over and over, rather than generating new sub-problems. 
   - When a problem have optimal substructure and overlapping sub-problems, we can apply Dynamic Programming to it.

2. *Stack* 

   ```java
   	public int stackSolution(String s) {
   		int result = 0;
   		Stack<Integer> parenthesesStack = new Stack<Integer>();
   		/*
   		 *  set boundary for invalid situation, 
   		 *  when the stack is empty, the part before that index is invalid
   		 */
   		parenthesesStack.push(-1);
   		for(int i=0; i<s.length(); i++) {
   			if(s.charAt(i) == '(') {
   				// when meet '(', push the index to stack
   				parenthesesStack.push(i);
   			}else {
   				// when meet ')', pop the first item from stack
   				parenthesesStack.pop();
   				if(parenthesesStack.empty()) {
   					// if the stack is empty, set the new invalid boundary
   					parenthesesStack.push(i);
   				}else {
   					/*
   					 *  the distance between current index and first item from stack
   					 *  is the length of longest valid parentheses for that character
   					 */
   					result = Math.max(result, i - parenthesesStack.peek());
   				}
   			}
   		}
   		return result;
   	}
   ```

   Time Complexity: **O(n)** 

   Space Complexity: **O(n)** 

3. *Loop with no extra space* 

   ```java
   	public int noExtraSpaceSolution(String s) {
   		int result = 0, left = 0, right = 0;
   		// go through from left to right, right should never great than left
   		for(int i=0; i<s.length(); i++) {
   			if(s.charAt(i) == '(') {
   				left++;
   			}else {
   				right++;
   			}
   			if(left == right) {
   				// when left equals to right, it's a valid parentheses
   				result = Math.max(result, left + right);
   			}
   			if(right > left) {
   				/*
   				 *  when right is great than left, 
   				 *  previous substring are invalid, reset right and left to 0
   				 */
   				left = right = 0;
   			}
   		}
   		
   		left = right = 0;
   		// go through from right to left, left should never great than right
   		for(int i=s.length()-1; i>=0; i--) {
   			if(s.charAt(i) == '(') {
   				left++;
   			}else {
   				right++;
   			}
   			if(left == right) {
   				result = Math.max(result, left + right);
   			}
   			if(left > right) {
   				/* when left is great than right, 
   				 * previous substring are invalid, reset right and left to 0
   				 */
   				left = right = 0;
   			}
   		}
   		return result;
   	}
   ```

   Time Complexity: **O(n)** 

   Space Complexity: **O(1)**

    