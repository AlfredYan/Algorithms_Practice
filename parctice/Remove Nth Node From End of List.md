# Remove Nth Node From End of List

**Question:**  

Given a linked list, remove the *n*-th node from the end of list and return its head.

*Note:* Given *n* will always be valid. And in one pass.

**Example:** 

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Solution:**  [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/RemoveNthNodeFromEnd.java)] 

```java
	// Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public ListNode removeNthNodeFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// first pointer goes to the position that has n nodes apart from second pointer
		for(int i=0; i<=n; i++) {
			first = first.next;
		}
		/* first pointer goes to the end of list, maintaining the gap
		*the next node of second pointer is the node that need to be removed*/
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
```

Time Complexity: **O(n)** , where n is the length of the node list.

Space Complexity: **O(1)** 