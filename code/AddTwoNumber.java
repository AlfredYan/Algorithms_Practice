
public class AddTwoNumber {
	
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
	
	public static void main(String[] args) {
		
		// first value
		ListNode aFirstDigit = new ListNode(2);
		ListNode aSecondDigit = new ListNode(4);
		ListNode aThirdDigit = new ListNode(3);
		aFirstDigit.next = aSecondDigit;
		aSecondDigit.next = aThirdDigit;
		
		// second value
		ListNode bFirstDigit = new ListNode(5);
		ListNode bSecondDigit = new ListNode(6);
		ListNode bThirdDigit = new ListNode(4);
		bFirstDigit.next = bSecondDigit;
		bSecondDigit.next = bThirdDigit;
		
		AddTwoNumber demo = new AddTwoNumber();
		ListNode result = demo.addTwoNumbers(aFirstDigit, bFirstDigit);
		while(result != null) {
			System.out.print(result.val);
			result = result.next;
		}
	}
}

class ListNode {
  	int val;
  	ListNode next;
  	ListNode(int x) { val = x; }
}
