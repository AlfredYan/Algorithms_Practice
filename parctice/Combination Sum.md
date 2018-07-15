# Combination Sum

## Combination Sum I

**Question:** 

Given a **set** of candidate numbers (`candidates`) **(without duplicates)** and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

The **same** repeated number may be chosen from `candidates` unlimited number of times.

*Note:*

- All numbers (including `target`) will be positive integers.
- The solution set must not contain duplicate combinations.

**Example:** 

```
// Example 1
Input: candidates = [2,3,6,7], target = 7,
Output:
[
  [7],
  [2,2,3]
]

// Example 2
Input: candidates = [2,3,5], target = 8,
Output:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/CombinationSum.java)] 

```java
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // sort the array first
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
	
	public void helper(int[] candidates, int target, int startPos, 
                       List<Integer> combination, List<List<Integer>> result) {
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
```

Time Complexity: ***O*(n<sup>m</sup>)**, where `n` is the length of array and `m` is the number of combinations.

Space Complexity: ***O*(m)**, where `m` is the number of combinations.

## Combination Sum II

**Question:** 

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

Each number in `candidates` may only be used **once** in the combination.

*Note:*

- All numbers (including `target`) will be positive integers.
- The solution set must not contain duplicate combinations.

**Example:** 

```
// Example 1
Input: candidates = [10,1,2,7,6,1,5], target = 8,
Output:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

// Example 2 
Input: candidates = [2,5,2,1,2], target = 5,
Output:
[
  [1,2,2],
  [5]
]
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/CombinationSumII.java)]

```java
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		helper(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}
	
	public void helper(int[] candidates, int target, int startPos, 
                       List<Integer> combination, List<List<Integer>> result) {
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
```

Time Complexity: ***O*(n<sup>m</sup>)**, where `n` is the number of unique value in the array and `m` is the number of combinations.

Space Complexity: ***O*(m)**, where `m` is the number of combinations.