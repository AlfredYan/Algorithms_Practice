import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		
		// if only less than 2 items in the array, do nothing
		if(nums != null && nums.length < 2) return nums.length;
		
		int uniqueLength = 0;
		
		/* start at second index, go through the array
		 * the first item always a new number
		 */
		for(int i=1; i<nums.length; i++) {
			if(nums[uniqueLength] != nums[i]) {
				// when we find a new number, store to the next index
				nums[++uniqueLength] = nums[i];
			}
		}
		
		return uniqueLength+1;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray demo = new RemoveDuplicatesFromSortedArray();
		int[] array1 = new int[]{1,1,2};
		int[] array2 = new int[]{0,0,1,1,1,2,2,3,3,4};
		System.out.println(demo.removeDuplicates(array1));
		System.out.println(Arrays.toString(array1));
		System.out.println(demo.removeDuplicates(array2));
		System.out.println(Arrays.toString(array2));
	}
}
