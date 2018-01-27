# Median of Two Sorted Arrays

**Question:** 

There are two sorted arrays **nums1** and **nums2** of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

**Example1:** 

```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```

**Example2:** 

```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

**Solution:** 

```java
	public double findMedianSortedArrays(int[] setA, int[] setB) {
		
		int numSetA = setA.length;
		int numSetB = setB.length;
		
		// ensure splitSetB is greater than 0,
		// SetB must has more elements than SetA
		if(numSetA > numSetB) {
			int[] tmpSet = setA;
			setA = setB;
			setB = tmpSet;
			
			int tmp = numSetA;
			numSetA = numSetB;
			numSetB = tmp;
		}
		
		int minSplitSetA = 0;
		int maxSplitSetA = numSetA;
		// initialize the half length
		int halfLength = (numSetA + numSetB + 1) / 2;
		
		while(minSplitSetA <= maxSplitSetA) {
			// initialize splitSetA at middle of the setA  
			int splitSetA = (minSplitSetA + maxSplitSetA) / 2;
			int splitSetB = halfLength - splitSetA;
			
			if(minSplitSetA < splitSetA && setA[splitSetA - 1] > setB[splitSetB]) {
				// Biggest value in left SetA is greater than smallest value is right SetB 
				// SplitSetA is too big
				// ensure the minSplitSet < splitSetA FIRST!
				maxSplitSetA--;
			}else if (maxSplitSetA > splitSetA && setB[splitSetB - 1] > setA[splitSetA]) {
				// Biggest value in left SetB is greater than smallest value is right SetA
				// SplitSetA is too small
				// // ensure the maxSplitSetA > splitSetA FIRST!
				minSplitSetA++;
			}else {
				int maxLeft = 0;
				if(splitSetA == 0) {
					// Whole SetA are at second half sets
					maxLeft = setB[splitSetB - 1];
				}else if (splitSetB == 0) {
					// Whole SetB are at second half sets
					maxLeft = setA[splitSetA - 1];
				}else {
					maxLeft = Math.max(setA[splitSetA - 1], setB[splitSetB - 1]);
				}
				
				// when size of SetA and SetB are odd
				if((numSetA + numSetB) % 2 == 1) {
					return maxLeft;
				}
				
				int minRight = 0;
				if(splitSetA == numSetA) {
					// Whole SetA are at first half sets
					minRight = setB[splitSetB];
				}else if(splitSetB == numSetB){
					// Whole SetB are at first half sets
					minRight = setA[splitSetA];
				}else {
					minRight = Math.min(setA[splitSetA], setB[splitSetB]);
				}
				
				return (maxLeft + minRight) / 2.0;
			}
		}
		
		return 0.0;
	}
```

Time Complexity: **O(log(min(m, n)))** 

Space Complexity: **O(1)** 

**Note:** 

The **median** is used for dividing a set into equal length subsets, that one subset is always greater than the other. The main idea of this problem is: cut two sets A&B at random positions, then put Left_A and Left_B to a set and Right_A and Right_B to another set. 

We have Left_Part and Right_Part. What we need to ensure is:

1. len(Left_Part) = len(Right_Part)
2. max(Left_Part) < min(Right_Part)