
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		
		// calculate the area from the points in most right and most left
		int left = 0, right = height.length-1, maxArea = 0, currArea = 0;
		
		while(left < right) {
			
			// compare the area with current points with max area
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			
			if(height[left] > height[right])
				// when the left line is higher, move the right line
				right--;
			else
				// when the right line is higher, move the left line
				left++;
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater demo = new ContainerWithMostWater();
		
		int[] testArray_0 = {1, 1};
		System.out.println(demo.maxArea(testArray_0));
		
		int[] testArray_1 = {1, 9, 2, 4, 3, 5};
		System.out.println(demo.maxArea(testArray_1));
	}
}
