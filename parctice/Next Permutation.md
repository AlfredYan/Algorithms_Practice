# Next Permutation

**Question:** 

Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers. 

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 

The replacement must be **in-place** and use only constant extra memory.

**Example:** 

```
// Example 1
Input: [1,2,3]
Output: [1,3,2]

// Example 2
Input: [3,2,1]
Output: [1,2,3]

// Example 3
Input: [1,1,5]
Output: [1,5,1]
```

**Solution:**  [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/NextPermutation.java)] 

```java
	public void nextPermutation(int[] nums) {
		
		if(nums == null || nums.length < 2) return;
		
		// find the index of first decreasing element
		int decreaseIndex = nums.length - 2;
		while(decreaseIndex >= 0 
              && nums[decreaseIndex+1] <= nums[decreaseIndex]) {
			decreaseIndex--;
		}
		
		if(decreaseIndex >= 0) {
			/* if current permutation is not the largest one
			 * swap the value at the decreaseIndex with the 
			 * value that is great than it (count from tail)
			 */
			int swapedIndex = nums.length - 1;
			while(swapedIndex >= decreaseIndex 
                  && nums[swapedIndex] <= nums[decreaseIndex]) {
				swapedIndex--;
			}
			swap(nums, decreaseIndex, swapedIndex);
		}
		// reverse the part that is after the decreasing index of the array
		reverse(nums, decreaseIndex+1);
	}
	
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
	
	private void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while(start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
```

Time Complexity: **O(n)** 

Space Complexity: **O(1)** 

**Algorithm:** 

1. Find the first pair of two successive numbers ``a[i]`` and ``a[i-1]`` which satisfy ``a[i] > a[i-1]`` , start from the tail of the array. We record the index ``i-1`` . To find the next great permutation, we only need to rearrange the right part of ``a[i-1]`` , include itself.
2. From the tail of the array, find a number ``a[j]`` who is the first number that great than ``a[i-1]`` . We swap ``a[i-1]`` and ``a[j]`` .
3.  Now the right part of ``a[i-1]`` is in descending order, we swap them. And we get the next great permutation.