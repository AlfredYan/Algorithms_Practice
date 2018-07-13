# Search Insert Position

**Question:** 

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. Assume no duplicates in the array.

**Example:** 

```
// Example 1
Input: [1,3,5,6], 5
Output: 2

// Example 2
Input: [1,3,5,6], 2
Output: 1

// Example 3
Input: [1,3,5,6], 7
Output: 4

// Example 4
Input: [1,3,5,6], 0
Output: 0
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/SearchInsertPosition.java)] 

```java
	public int searchInsertPosition(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		/*
		 * Do binary search when start less or equals to end.
		 * If the target is not in the array, start will equals to end
		 * When value is great than target, the target should insert before value,
		 * end minus 1 and start will be the result.
		 * When value is less than target, the target should insert after value,
		 * start add 1 and start will be the result,
		 * So we can return start as result at the end.
		 */
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) return mid;
			if(nums[mid] > target) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
```

Time Complexity: ***O*(log *n*)** 

Space Complexity: ***O*(1)**

