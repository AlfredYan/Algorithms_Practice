# Two Sum

**Question:** 

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the *same* element twice.

**Example:** 

```java
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Solution:** 

```java
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
```

Time Complexity: ***O(n)*** 

Space Complexity: ***O(n)***  

**Note:** 

HashMap stores the data in (Key, Value) pairs and uses a technique Hashing. It internally uses linked list to store key-value pairs.

Internally HashMap contains an array of Node. and each node represents as a class which contains:

1. *int hash* 
2. *K key* 
3. *V value* 
4. *Node next*  (the reference of its own object, which means it's a linked list)

A hash value represents the hash value of the key. All the keys with the same hash value are put in the same linked list.

HashMap doesn't allow duplicate keys, but allows duplicate values. It is unsynchronized and does not guarantee the order of the map.s