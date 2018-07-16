
public class FirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) return 1;
		int index = 0, result = 1;
		while(index < nums.length) {
			/*
			 * When the value at the index is not the index,
			 * make sure the value is great than 0 and less than the length of array.
			 * Swap the the value at the index and the number with the value index.
			 * Make the value at the index equals to index
			 */
			if(nums[index] > 0 && nums[index] < nums.length && nums[index] != nums[nums[index]]) {
				swap(nums, index, nums[index]);
			}else {
				index++;
			}
		}
		
		// search the index that the value is not equals to the index
		while(result < nums.length) {
			if(result != nums[result]) break;
			result++;
		}
		
		if(result >= nums.length) {
			// check if the next positive is at index 0
			return nums[0] == result ? ++result : result;
		}else {
			return result;
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		FirstMissingPositive demo = new FirstMissingPositive();
		int[] nums1 = new int[] {1,2,0};
		int[] nums2 = new int[] {3,4,-1,1};
		int[] nums3 = new int[] {7,8,9,11,12};
		
		System.out.println(demo.firstMissingPositive(nums1));
		System.out.println(demo.firstMissingPositive(nums2));
		System.out.println(demo.firstMissingPositive(nums3));
	}
}
