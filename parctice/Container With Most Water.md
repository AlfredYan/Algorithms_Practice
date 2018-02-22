# Container With Most Water

**Question:** 

Given *n* non-negative integers *a<sub>1</sub>*, *a<sub>2</sub>*, ..., *a<sub>n</sub>*, where each represents a point at coordinate (*i*, *a<sub>i</sub>*). *n* vertical lines are drawn such that the two endpoints of line *i* is at (*i*, *a<sub>i</sub>*) and (*i*, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Don't slant the container and *n* is at least 2.

**Example** 

```
Input: [1, 1]
Output: 1
```

```
Input: [1, 9, 2, 4, 3, 5]
Output: 20
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ContainerWithMostWater.java)]

```java
	public int maxArea(int[] height) {
		
		// calculate the area from the points in most right and most left
		int left = 0, right = height.length-1, maxArea = 0, currArea = 0;
		
		while(left < right) {
			
			// compare the area with current points with max area
			maxArea = Math.max(maxArea, 
                      	Math.min(height[left], height[right]) * (right - left));
			
			if(height[left] > height[right])
				// when the left line is higher, move the right line
				right--;
			else
				// when the right line is higher, move the left line
				left++;
		}
```

Time Complexity: **O(n)** 

Space Complexity: **O(1)** 

**Note:** 

The lines will always be limited by the height of the shorter line.