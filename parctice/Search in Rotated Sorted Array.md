# Search in Rotated Sorted Array

**Question:** 

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

Give a target value to search. If found in the array return its index, otherwise return `-1`. Assume no duplicate exists in the array. The algorithm's runtime complexity must be in the order of *O*(log *n*).

**Example:** 

```
// Example 1
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

// Example 2 
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/SearchInRotatedSortedArray.java)] 

```java
	public int searchRotatedSortedArray(int[] nums, int target){
		int start = 0;
		int end = nums.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) return mid;
			// make sure which part is sorted
			if(nums[start] <= nums[mid]) {
				// when the first part is sorted
				if(target < nums[mid] && target >= nums[start]) {
					/* 
					 * target is less than middle value and great than start value
					 * so target is at first part
					 */
					end = mid - 1;
				}else {
					// otherwise target is at second part
					start = mid + 1;
				}
			}else {
				//when the second part is sorted
				if(target > nums[mid] && target <= nums[end]) {
					/*
					 * target is great than middle value and less than end value
					 * so target is at second part
					 */
					start = mid + 1;
				}else {
					// other target is at first part
					end = mid - 1;
				}
			}
		}
		return -1;
	}
```

Time Complexity: ***O*(log *n*)** 

Space Complexity: ***O*(1)** 