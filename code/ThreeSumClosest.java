import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // initialize the closet value
        int cloest = nums[0] + nums[1] + nums[nums.length-1];
        // check each number
        for(int i=0; i<nums.length-2; i++){
            int start=i+1, end=nums.length-1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum>target){
                    end--;
                }else{
                    start++;
                }
                // if the sum is closer than current closest value
                if(Math.abs(sum-target) < Math.abs(cloest-target)){
                    cloest = sum;
                }
            }
        }
        return cloest;
    }
	
	public static void main(String[] args) {
		ThreeSumClosest demo = new ThreeSumClosest();
		int[] nums = {-1, 2, 1, -4};
		System.out.println(demo.threeSumClosest(nums, 1));
	}
}
