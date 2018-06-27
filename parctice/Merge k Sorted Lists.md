# Merge k Sorted Lists

**Question:** 

Merge *k* sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

**Example:** 

```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

**Solution:**  [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/MergedKSortedLists.java)] 

```java
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		
		// create a priority queue and set the comparison rule
		PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>((n1, n2) -> n1.val-n2.val);
		
		// put each list to the priority queue
		for(int i=0; i<lists.length; i++) {
			if(lists[i] != null) {
				pQueue.add(lists[i]);
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode currNode = dummy;
		while(!pQueue.isEmpty()) {
			// put the node with the smallest value to the list
			currNode.next = pQueue.poll();
			// assign currNode to it's next node 
			currNode = currNode.next;
			
			if(currNode.next != null) {
				// put the next node of the node that just be added to the list
				pQueue.add(currNode.next);
			}
		}
		
		return dummy.next;
	}
```

Time Complexity: **O(n*logk)**

Space Complexity: **O(n+k)** 

*Note: ``k`` is the number of linked lists and ``n`` is the number of nodes in the final linked list.* 