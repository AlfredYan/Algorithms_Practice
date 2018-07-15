import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
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
		
		for(int i= startPos; i<candidates.length; i++) {
			// skip duplicates
			if(i > startPos && candidates[i] == candidates[i-1]) continue;
			int newTarget = target - candidates[i];
			if(newTarget >= 0) {
				combination.add(candidates[i]);
				helper(candidates, newTarget, i+1, combination, result);
				combination.remove(combination.size() - 1);
			}else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII demo = new CombinationSumII();
		int[] candidates1 = new int[] {10,1,2,7,6,1,5};
		int[] candidates2 = new int[] {2,5,2,1,2};
		
		List<List<Integer>> result1 = demo.combinationSum(candidates1, 8);
		for(List<Integer> l : result1) {
			System.out.println(l);
		}
		
		System.out.println();
		List<List<Integer>> result2 = demo.combinationSum(candidates2, 5);
		for(List<Integer> l : result2) {
			System.out.println(l);
		}
	}
}
