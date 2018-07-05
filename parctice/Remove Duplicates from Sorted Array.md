# Remove Duplicates from Sorted Array

**Question:** 

Given a sorted array *nums*, remove the duplicates **in-place** such that each element appear only *once* and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

**Example:** 

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.
```

```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/RemoveDuplicatesFromSortedArray.java)] 

```java
	public int removeDuplicates(int[] nums) {
		
		// if only less than 2 items in the array, do nothing
		if(nums != null && nums.length < 2) return nums.length;
		
		int uniqueLength = 0;
		
		/* start at second index, go through the array
		 * the first item always a new number
		 */
		for(int i=1; i<nums.length; i++) {
			if(nums[uniqueLength] != nums[i]) {
				// when we find a new number, store to the next index
				nums[++uniqueLength] = nums[i];
			}
		}
		
		// add the first item when return
		return uniqueLength+1;
	}
```

Time Complexity: **O(n)** 

Space Complexity: **O(1)** 