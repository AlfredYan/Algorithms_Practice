import java.util.PriorityQueue;

public class MergedKSortedLists {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
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
	
	public static void main(String[] args) {
		MergedKSortedLists demo = new MergedKSortedLists();
		
		ListNode list1a = demo.new ListNode(1);
		ListNode list1b = demo.new ListNode(4);
		ListNode list1c = demo.new ListNode(5);
		list1a.next = list1b;
		list1b.next = list1c;
		
		ListNode list2a = demo.new ListNode(1);
		ListNode list2b = demo.new ListNode(3);
		ListNode list2c = demo.new ListNode(4);
		list2a.next = list2b;
		list2b.next = list2c;
		
		ListNode list3a = demo.new ListNode(2);
		ListNode list3b = demo.new ListNode(6);
		list3a.next = list3b;
		
		ListNode[] lists = {list1a, list2a, list3a};
		
		ListNode result = demo.mergeKLists(lists);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
