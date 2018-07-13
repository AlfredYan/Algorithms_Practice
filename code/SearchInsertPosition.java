
public class SearchInsertPosition {
	public int searchInsertPosition(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		/*
		 * Do binary search when start less or equals to end.
		 * If the target is not in the array, start will equals to end
		 * When value is great than target, the target should insert before value,
		 * end minus 1 and start will be the result.
		 * When value is less than target, the target should insert after value,
		 * start add 1 and start will be the result,
		 * So we can return start as result at the end.
		 */
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) return mid;
			if(nums[mid] > target) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		SearchInsertPosition demo = new SearchInsertPosition();
		int[] nums = new int[] {1,3,5,6};
		System.out.println(demo.searchInsertPosition(nums, 2));
		System.out.println(demo.searchInsertPosition(nums, 1));
		System.out.println(demo.searchInsertPosition(nums, 4));
		System.out.println(demo.searchInsertPosition(nums, 0));
	}
}
