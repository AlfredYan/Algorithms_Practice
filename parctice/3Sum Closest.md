# 3Sum Closest

**Question:** 

Given an array `nums` of *n* integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example:** 

```
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

**Soultion:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/ThreeSumClosest.java)]

```java
	import java.util.Arrays;	
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // initialize the closet value
        int cloest = nums[0] + nums[1] + nums[nums.length-1];
        // check each number
        for(int i=0; i<nums.length-2; i++){
            int start=i+1, end=nums.length-1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum>target){
                    end--;
                }else{
                    start++;
                }
                // if the sum is closer than current closest value
                if(Math.abs(sum-target) < Math.abs(cloest-target)){
                    cloest = sum;
                }
            }
        }
        return cloest;
    }
```

Time Complexity: **O(n<sup>2</sup>)**

Space Complexity: **O(n)** 