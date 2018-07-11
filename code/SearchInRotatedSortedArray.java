
public class SearchInRotatedSortedArray {
	public int searchRotatedSortedArray(int[] nums, int target){
		int start = 0;
		int end = nums.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) return mid;
			// make sure which part is sorted
			if(nums[start] <= nums[mid]) {
				// when the first part is sorted
				if(target < nums[mid] && target >= nums[start]) {
					/* 
					 * target is less than middle value and great than start value
					 * so target is at first part
					 */
					end = mid - 1;
				}else {
					// otherwise target is at second part
					start = mid + 1;
				}
			}else {
				//when the second part is sorted
				if(target > nums[mid] && target <= nums[end]) {
					/*
					 * target is great than middle value and less than end value
					 * so target is at second part
					 */
					start = mid + 1;
				}else {
					// other target is at first part
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SearchInRotatedSortedArray demo = new SearchInRotatedSortedArray();
		int[] nums = new int[] {4,5,6,7,0,1,2};
		System.out.println(demo.searchRotatedSortedArray(nums, 0));
		System.out.println(demo.searchRotatedSortedArray(nums, 3));
	}
}
