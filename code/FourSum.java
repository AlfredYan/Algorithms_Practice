import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if(len < 4) return result;
		Arrays.sort(nums);
		for(int i=0; i<len-3; i++) {
			// avoid duplicate candidate
			if(i>0 && nums[i]==nums[i-1]) continue; 
			// when the first candidate is too large, search finished
			if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
			// when the first candidate is too small, go to next candidate
			if(nums[i] + nums[len-1] + nums[len-2] + nums[len-3] < target) continue;
			for(int j=i+1; j<len-2; j++) {
				// same check as above but for the other 3 numbers
				if(j>i+1 && nums[j]==nums[j-1]) continue;
				if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
				if(nums[i] + nums[j] + nums[len-1] + nums[len-2] < target) continue;
				int low=j+1, high=len-1;
				while(low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if(sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						// skip duplicate result
						while(low<high && nums[low]==nums[low+1]) low++;
						while(low<high && nums[high]==nums[high-1]) high--;
						low++;
						high--;
					}else if (sum < target) {
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
		FourSum demo = new FourSum();
		int[] nums1 = {1, 0, -1, 0, -2, 2};
		int[] nums2 = {-3,-2,-1,0,0,1,2,3};
		System.out.println(demo.fourSum(nums1, 0).toString());
		System.out.println(demo.fourSum(nums2, 0).toString());
	}
}
