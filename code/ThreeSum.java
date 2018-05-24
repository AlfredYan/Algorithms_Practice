import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length < 3) return result;
		// For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array
		for(int i=0; i<nums.length-2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])) { // skip same result
				// start from header and tail
				int low = i+1, high = nums.length - 1, sum = 0 - nums[i];
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						// skip same result
						while(low < high && nums[low] == nums[low+1]) low++;
						while(low < high && nums[high] == nums[high-1]) high--;
						low++;
						high--;
					}else if(nums[low] + nums[high] < sum){
						low++;
					}else {
						high--;
					}
				}
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		ThreeSum demo = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(demo.threeSum(nums));
	}
}
