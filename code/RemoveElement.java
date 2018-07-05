import java.util.Arrays;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if(nums == null) return 0;
		int index = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				/* when the item is not equal to the value
				 * assign the item to the position of the index
				 */
				nums[index] = nums[i];
				index++;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		RemoveElement demo = new RemoveElement();
		int[] array1 = new int[] {3,2,2,3};
		int[] array2 = new int[] {0,1,2,2,3,0,4,2};
		System.out.println(demo.removeElement(array1, 3));
		System.out.println(Arrays.toString(array1));
		System.out.println(demo.removeElement(array2, 2));
		System.out.println(Arrays.toString(array2));
	}
}
