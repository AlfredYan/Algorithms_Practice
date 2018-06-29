# Swap Nodes in Pairs

**Question:** 

Given a linked list, swap every two adjacent nodes and return its head.

*Note:*

- Your algorithm should use only constant extra space.
- You may **not** modify the values in the list's nodes, only nodes itself may be changed.

**Example:** 

```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/SwapNodesInPairs.java)] 

```java
	public ListNode swapNodesInPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode currNode = dummy;
		while(currNode.next != null && currNode.next.next != null) {
			ListNode tempNode1 = currNode.next;
			ListNode tempNode2 = currNode.next.next;
			
			// swap two nodes
			tempNode1.next = tempNode2.next;
			currNode.next = tempNode2;
			tempNode2.next = tempNode1;
			
			// go to next pair of nodes
			currNode = currNode.next.next;
		}
		
		return dummy.next;
	}
```

Time Complexity: **O(n)** 

Space Complexity: **O(n)** 