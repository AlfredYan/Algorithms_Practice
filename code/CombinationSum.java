import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // sort the array first
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
	
	public void helper(int[] candidates, int target, int startPos, List<Integer> combination, List<List<Integer>> result) {
		// when we find the combination, add it to result
		if(target == 0) {
			result.add(new ArrayList<Integer>(combination));
			return;
		}
		
		for(int i=startPos; i<candidates.length; i++) {
			int newTarget = target - candidates[i];
			// when new target is great or equal to 0
			if(newTarget >=0) {
				// add the number to the combination
				combination.add(candidates[i]);
				// handle the next number of the combination, i can be reused
				helper(candidates, newTarget, i, combination, result);
				// remove the last number and try next number
				combination.remove(combination.size() - 1);
			}else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum demo = new CombinationSum();
		int[] candidates1 = new int[] {2,3,6,7};
		int[] candidates2 = new int[] {2,3,5};
		
		List<List<Integer>> result1 = demo.combinationSum(candidates1, 7);
		for(List<Integer> l : result1) {
			System.out.println(l);
		}
		
		System.out.println();
		List<List<Integer>> result2 = demo.combinationSum(candidates2, 8);
		for(List<Integer> l : result2) {
			System.out.println(l);
		}
	}
}
