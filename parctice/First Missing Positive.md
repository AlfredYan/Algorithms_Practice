# First Missing Positive

**Question:** 

Given an unsorted integer array, find the smallest missing positive integer. The algorithm should run in *O*(*n*) time and uses constant extra space.

**Example:** 

```
// Example 1
Input: [1,2,0]
Output: 3

// Example 2
Input: [3,4,-1,1]
Output: 2

// Example 3
Input: [7,8,9,11,12]
Output: 1
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/FirstMissingPositive.java)] 

```java
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) return 1;
		int index = 0, result = 1;
		while(index < nums.length) {
			/*
			 * When the value at the index is not the index,
			 * make sure the value is great than 0 and less than the length of array.
			 * Swap the the value at the index and the number with the value index.
			 * Make the value at the index equals to index
			 */
			if(nums[index] > 0 && nums[index] < nums.length 
               && nums[index] != nums[nums[index]]) {
				swap(nums, index, nums[index]);
			}else {
				index++;
			}
		}
		
		// search the index that the value is not equals to the index
		while(result < nums.length) {
			if(result != nums[result]) break;
			result++;
		}
		
		if(result >= nums.length) {
			// check if the next positive is at index 0
			return nums[0] == result ? ++result : result;
		}else {
			return result;
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
```

Time Complexity: ***O*(*n*)** 

Space Complexity: ***O*(*1*)** 