# Merge Two Sorted Lists

**Question:** 

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:** 

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

**Solution:**  [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/MergeTwoSortedLists.java)] 

```java
	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		ListNode mergedList;
		
		if(l1 == null) return l2;
		else if(l2 == null) return l1;
		
		if(l1.val < l2.val) {
			mergedList = l1;
			mergedList.next = mergeTwoSortedLists(l1.next, l2);
		}else {
			mergedList = l2;
			mergedList.next = mergeTwoSortedLists(l1, l2.next);
		}
		
		return mergedList;
	}
```

Time Complexity: **O(m+n)**, where ``m`` is the length of the first list and ``n`` is the length of the second one.

Space Complexity: **O(m+n)**, where ``m`` is the length of the first list and ``n`` is the length of the second one.