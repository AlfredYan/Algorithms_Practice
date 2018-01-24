import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            int numToFind = target - nums[i];
            if(map.containsKey(numToFind)){
              	// the number exists in the map, return the solution immediately
                return new int[] {map.get(numToFind), i};
            }
          
          	// if the number not exists, put the number as Key, index as Value into map
            map.put(nums[i], i);
        }
  
  		// no solution, throw exception
        throw new IllegalArgumentException("No solution");
	}
	
	public static void main(String[] args) {
		TwoSum demo = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[] result = demo.twoSum(nums, target);
		
		System.out.printf("The result is [%d, %d]", result[0], result[1]);
		
	}
}
