import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		
		if(nums == null || nums.length < 2) return;
		
		// find the index of first decreasing element
		int decreaseIndex = nums.length - 2;
		while(decreaseIndex >= 0 && nums[decreaseIndex+1] <= nums[decreaseIndex]) {
			decreaseIndex--;
		}
		
		if(decreaseIndex >= 0) {
			/* if current permutation is not the largest one
			 * swap the value at the decreaseIndex with the 
			 * value that is great than it (count from tail)
			 */
			int swapedIndex = nums.length - 1;
			while(swapedIndex >= decreaseIndex && nums[swapedIndex] <= nums[decreaseIndex]) {
				swapedIndex--;
			}
			swap(nums, decreaseIndex, swapedIndex);
		}
		/* reverse the part that is after the decreasing index of the array
		 * when it's the largest case, reverse the total array
		 */
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
	
	public static void main(String[] args) {
		NextPermutation demo = new NextPermutation();
		int[] nums1 = new int[] {1,2,3};
		int[] nums2 = new int[] {3,2,1};
		int[] nums3 = new int[] {1,1,5};
		demo.nextPermutation(nums1);
		System.out.println(Arrays.toString(nums1));
		demo.nextPermutation(nums2);
		System.out.println(Arrays.toString(nums2));
		demo.nextPermutation(nums3);
		System.out.println(Arrays.toString(nums3));
	}
}
