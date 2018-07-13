import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1,-1};
		int firstPosition = helper(nums, target, true);
		if(firstPosition >= nums.length || nums[firstPosition] != target) return result;
		result[0] = firstPosition;
		result[1] = helper(nums, target, false) - 1;
		return result;
	}
	
	public int helper(int[] nums, int target, boolean searchFirst) {
		int start = 0;
		int end = nums.length;
		/*
		 *  do binary search until start equals to end
		 *  which is the index of target
		 */
		while(start < end) {
			int mid = (start + end) / 2;
			/*
			 * When we find the first position, we care about the left subarray.
			 * For the last position, just consider the right subarray.
			 * When searchFirst is true, we find the index of the first target.
			 * When searchFirst is false, find the index which is next to the index of 
			 * the last target.
			 */
			if((searchFirst && nums[mid] == target) || nums[mid] > target) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray demo = new FindFirstAndLastPositionOfElementInSortedArray();
		int[] nums = new int[] {5,7,7,8,8,10};
		System.out.println(Arrays.toString(demo.searchRange(nums, 8)));
		System.out.println(Arrays.toString(demo.searchRange(nums, 6)));
	}
}
