
public class SwapNodesInPairs {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
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
	
	public static void main(String[] args) {
		SwapNodesInPairs demo = new SwapNodesInPairs();
		
		ListNode node1 = demo.new ListNode(1);
		ListNode node2 = demo.new ListNode(2);
		ListNode node3 = demo.new ListNode(3);
		ListNode node4 = demo.new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode result = demo.swapNodesInPairs(node1);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
