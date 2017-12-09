/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
 // 22 + 798 = 2->2 + 8->9->7 = 0->2->8
 // 99 + 982 = 9 -> 9 + 2-> 8 -> 9
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    int carry = 0;
	    ListNode result = null;
	    ListNode tmp1 = a;
	    ListNode tmp2 = b;
	    ListNode tail = null;
	    while ((tmp1 != null) || (tmp2 != null)) {
	        int sum = 0;
	        if (tmp1 != null) {
	            sum += tmp1.val;
	            tmp1 = tmp1.next;
	        }
	        if (tmp2 != null) {
	            sum += tmp2.val;
	            tmp2 = tmp2.next;
	        }
	        sum += carry;
	       // System.out.println("sum = " + sum);
	        if (sum >= 10) {
	            carry = sum/10;
	            sum = sum % 10;
	        } else 
	            carry = 0;
	        ListNode tmp = new ListNode(sum);
	        if (result == null) {
	            result = tmp;
	            tail = tmp;
	        } else {
	            // insert the 
	            tail.next = tmp;
	            tail = tmp;
	        }
	    }
	    if (carry > 0) {
	        ListNode tmp = new ListNode(carry);
	        tail.next = tmp;
	        tail = tmp;
	    }
	    return result;
	}
}
