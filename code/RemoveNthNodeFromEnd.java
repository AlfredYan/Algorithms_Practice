
public class RemoveNthNodeFromEnd {
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
	
	public static void main(String[] args) {
		RemoveNthNodeFromEnd demo = new RemoveNthNodeFromEnd();
		ListNode node1 = demo.new ListNode(1);
		ListNode node2 = demo.new ListNode(2);
		ListNode node3 = demo.new ListNode(3);
		ListNode node4 = demo.new ListNode(4);
		ListNode node5 = demo.new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		demo.removeNthNodeFromEnd(node1, 2);
	}
}
