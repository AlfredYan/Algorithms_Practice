# Add Two Number

**Question:** 

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example:** 

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

**Solution:** 

```java
// Definition for singly-linked list.
public class ListNode {
  	int val;
  	ListNode next;
  	ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
      	// create result and assign 0 as dummy value
        ListNode result = new ListNode(0);
        ListNode currNode = result;
        
      	// the carry for last digit
      	int carry = 0;
        
        // sum the value in each node with the same digit
        while(l1 != null || l2 != null) {
          
            int firstVal = (l1 != null) ? l1.val : 0;
            int secondVal = (l2 != null) ? l2.val : 0;
            int sum = carry + firstVal + secondVal;
            carry = sum / 10;
            currNode.next = new ListNode(sum % 10);
            
          	// go to next digit
          	currNode = currNode.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        // when the highest digit has carry (sum >= 10)
        if(carry > 0)
            currNode.next = new ListNode(carry);
        
      	// return the real result
        return result.next;
    }
}
```

