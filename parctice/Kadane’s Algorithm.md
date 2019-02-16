# Kadane’s Algorithm

**Description:** 

```
Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
```

*Kadane’s algorithm*  is to look for all positive contiguous segments of the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far.

**Examples:** 

1. Maximum Subarray

   **Q:** Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

   ```
   Input: [-2,1,-3,4,-1,2,1,-5,4],
   Output: 6
   Explanation: [4,-1,2,1] has the largest sum = 6.
   ```

   ```java
   // general case
   public int maxSubArray(int[] nums) {
       int size = nums.length; 
       int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
   
       for (int i = 0; i < size; i++) 
       { 
           // (a)
           max_ending_here = max_ending_here + a[i];
           // (b)
           if (max_ending_here < 0) 
               max_ending_here = 0;
           // (c)
           if (max_so_far < max_ending_here) 
               max_so_far = max_ending_here; 
       } 
       return max_so_far;
   }
   
   // Algorithm that can deal with the array that only has negative numbers
   public int maxSubArray(int[] nums) {
       int maxEndingHere = nums[0], maxSoFar = nums[0];
   
       for(int i=1; i<nums.length; i++){
           maxEndingHere = Math.max(nums[i], maxEndingHere+nums[i]);
           maxSoFar = Math.max(maxSoFar, maxEndingHere);
       }
   
       return maxSoFar;
   }
   ```

   

2. Best Time to Buy and Sell Stock

   **Q:** Say you have an array for which the *i*<sup>th</sup> element is the price of a given stock on day *i*. If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

   ```
   // Case 1
   Input: [7,1,5,3,6,4]
   Output: 5
   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
   
   // Case 2
   Input: [7,6,4,3,1]
   Output: 0
   Explanation: In this case, no transaction is done, i.e. max profit = 0.
   ```

   ```java
   public int maxProfit(int[] prices) {
       int maxEndingHere = 0;
       int maxSofar = 0;
   
       for(int i=1; i<prices.length; i++) {
           maxEndingHere = Math.max(0, maxEndingHere+prices[i]-prices[i-1]);
           maxSofar = Math.max(maxSofar, maxEndingHere);
       }
   
       return maxSofar;
   }
   ```

   

