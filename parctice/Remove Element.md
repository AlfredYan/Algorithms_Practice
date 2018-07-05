# Remove Element

**Question:** 

Given an array *nums* and a value *val*, remove all instances of that value **in-place** and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

**Example:** 

```
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length.
```

```
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
Note that the order of those five elements can be arbitrary.
It doesn't matter what values are set beyond the returned length.
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/RemoveElement.java)] 

```java
	public int removeElement(int[] nums, int val) {
		if(nums == null) return 0;
		int index = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				/* when the item is not equal to the value
				 * assign the item to the position of the index
				 */
				nums[index] = nums[i];
				index++;
			}
		}
		
		return index;
	}
```

Time Complexity: **O(n)** 

Space Complexity: **O(1)** 