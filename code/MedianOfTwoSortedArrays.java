
public class MedianOfTwoSortedArrays {

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
				// when biggest value in left SetA is greater than smallest value is right SetB 
				// SplitSetA is too big
				// ensure the minSplitSet < splitSetA FIRST!
				maxSplitSetA--;
			}else if (maxSplitSetA > splitSetA && setB[splitSetB - 1] > setA[splitSetA]) {
				// when biggest value in left SetB is greater than smallest value is right SetA
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
	
	public static void main(String[] args) {
		MedianOfTwoSortedArrays demo = new MedianOfTwoSortedArrays();
		
		int[] setA = {1, 3};
		int[] setB = {2};
		System.out.println(demo.findMedianSortedArrays(setA, setB));
		
		int[] setC = {1, 2};
		int[] setD = {3, 4};
		System.out.println(demo.findMedianSortedArrays(setC, setD));
		
	}
}
