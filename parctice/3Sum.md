# 3Sum 

**Question:** 

Given an array *S* of *n* integers, are there elements *a*, *b*, *c* in *S* such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero. *The solution set must not contain duplicate triplets.* 

**Example:** 

```
Given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ThreeSum.java)]

```java
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length < 3) return result;
        // For each possible first element
        // Make a standard bi-directional 2Sum sweep of the remaining part of the array
		for(int i=0; i<nums.length-2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])) { // skip same result
                // start from header and tail
				int low = i+1, high = nums.length - 1, sum = 0 - nums[i];
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						// skip same result
						while(low < high && nums[low] == nums[low+1]) low++;
						while(low < high && nums[high] == nums[high-1]) high--;
						low++;
						high--;
					}else if(nums[low] + nums[high] < sum){
						low++;
					}else {
						high--;
					}
				}
			}
		}
		
		return result;
	}
```

Time Complexity: **O(n<sup>2</sup>)**

Space Complexity: **O(n)** 

