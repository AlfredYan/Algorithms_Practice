# Find First and Last Position of Element in Sorted Array

**Question:** 

Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value. The algorithm's runtime complexity must be in the order of *O*(log *n*).

If the target is not found in the array, return `[-1, -1]`.

**Example:** 

```
// Example 1
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

// Example 2
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/FindFirstAndLastPositionOfElementInSortedArray.java)] 

```java
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1,-1};
		int firstPosition = helper(nums, target, true);
		if(firstPosition >= nums.length || nums[firstPosition] != target) return result;
		result[0] = firstPosition;
		result[1] = helper(nums, target, false) - 1;
		return result;
	}
	
	public int helper(int[] nums, int target, boolean searchFirst) {
		int start = 0;
		int end = nums.length;
		/*
		 *  do binary search until start equals to end
		 *  which is the index of target
		 */
		while(start < end) {
			int mid = (start + end) / 2;
			/*
			 * When we find the first position, we care about the left subarray.
			 * For the last position, just consider the right subarray.
			 * When searchFirst is true, we find the index of the first target.
			 * When searchFirst is false, find the index which is next to the index of 
			 * the last target.
			 */
			if((searchFirst && nums[mid] == target) || nums[mid] > target) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
```

Time Complexity: ***O*(log *n*)** 

Space Complexity: ***O*(1)**

