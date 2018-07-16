# Trapping Rain Water

**Question:** 

Given *n* non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

**Example:** 

```
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/TrappingRainWater.java)] 

1. *Dynamic Programming* 

   ```java
   	public int dpSolution(int height[]) {
   		if(height == null || height.length==0) return 0;
   		int result = 0, size = height.length;
   		int[] leftMax = new int[size];
   		int[] rightMax = new int[size];
   		
   		// Find maximum height of bar from left to the end
   		leftMax[0] = height[0];
   		for(int i=1; i<size; i++) {
   			leftMax[i] = Math.max(height[i], leftMax[i-1]);
   		}
   		
   		// Find maximum height of bar from right to the end
   		rightMax[size-1] = height[size-1];
   		for(int i=size-2; i>=0; i--) {
   			rightMax[i] = Math.max(height[i], rightMax[i+1]);
   		}
   		
   		/*
   		 *  choose the shorter side of left and right,
   		 *  then minus the height to calculate capacity
   		 */
   		for(int i=0; i<size; i++) {
   			result += Math.min(leftMax[i], rightMax[i]) - height[i];
   		}
   		
   		return result;
   	}
   ```

   Time Complexity: ***O*(n)** 

   Space Complexity: ***O*(n)** 

2. *2 Pointers* 

   ```java
   	public int twoPointerSolution(int height[]) {
   		if(height == null) return 0;
   		int left=0, right=height.length-1, maxLeft=0, maxRight=0, result=0;
   		
   		// when left equals to right, calculate finishes
   		while(left < right) {
   			// the shorter side can determine the capacity
   			if(height[left] < height[right]) {
   				/* if current height is great than max height from left, update it
   				 * otherwise, calculate the capacity by max left minus current height
   				 */
   				if(height[left] > maxLeft) {
   					maxLeft = height[left];
   				}else {
   					result += maxLeft - height[left];
   				}
   				left++;
   			}else {
   				/* if current height is great than max height from right, update it
   				 * otherwise, calculate the capacity by max right minus current height
   				 */
   				if(height[right] > maxRight) {
   					maxRight = height[right];
   				}else {
   					result += maxRight - height[right];
   				}
   				right--;
   			}
   		}
   		
   		return result;
   	}
   ```

   Time Complexity: ***O*(n)** 

   Space Complexity: ***O*(1)** 

