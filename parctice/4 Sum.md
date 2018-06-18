# 4 Sum

**Question:** 

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

*Note:* The solution set must not contain duplicate quadruplets.

**Example:** 

```
1. Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

2. Given array nums = [-3, -2, -1, 0, 0, 1, 2, 3], and target = 0.

A solution set is:
[
  [-3, -2, 2, 3], 
  [-3, -1, 1, 3], 
  [-3, 0, 0, 3], 
  [-3, 0, 1, 2], 
  [-2, -1, 0, 3], 
  [-2, -1, 1, 2], 
  [-2, 0, 0, 2], 
  [-1, 0, 0, 1]
]
```

**Solution:**  [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/FourSum.java)]

```java
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if(len < 4) return result;
		Arrays.sort(nums);
        
		for(int i=0; i<len-3; i++) {
			// avoid duplicate candidate
			if(i>0 && nums[i]==nums[i-1]) continue; 
			// when the first candidate is too large, search finished
			if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
			// when the first candidate is too small, go to next candidate
			if(nums[i] + nums[len-1] + nums[len-2] + nums[len-3] < target) continue;
            
			for(int j=i+1; j<len-2; j++) {
				// same check as above but for the other 3 numbers
				if(j>i+1 && nums[j]==nums[j-1]) continue;
				if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
				if(nums[i] + nums[j] + nums[len-1] + nums[len-2] < target) continue;
                
				int low=j+1, high=len-1;
				while(low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if(sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], 
                                                 nums[low], nums[high]));
						// skip duplicate result
						while(low<high && nums[low]==nums[low+1]) low++;
						while(low<high && nums[high]==nums[high-1]) high--;
						low++;
						high--;
					}else if (sum < target) {
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

Time Complexity: **O(n<sup>3</sup>)** 

Space Complexity: **O(n)** 