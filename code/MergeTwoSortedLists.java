public class MergeTwoSortedLists {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
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
	
	public static void main(String[] args) {
		MergeTwoSortedLists demo = new MergeTwoSortedLists();
		
		ListNode node1a = demo.new ListNode(1);
		ListNode node1b = demo.new ListNode(2);
		ListNode node1c = demo.new ListNode(4);
		node1a.next = node1b;
		node1b.next = node1c;
		
		ListNode node2a = demo.new ListNode(1);
		ListNode node2b = demo.new ListNode(3);
		ListNode node2c = demo.new ListNode(4);
		node2a.next = node2b;
		node2b.next = node2c;

		ListNode mergedList = demo.mergeTwoSortedLists(node1a, node2a);
		
		while(mergedList != null) {
			System.out.println(mergedList.val);
			mergedList = mergedList.next;
		}
	}
}
