/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode swapPairs(ListNode a) {
	    ListNode head = a;
	    ListNode cur = a;
	    if (cur.next == null)
	        return head;
	    ListNode next = cur.next;
	    while ((cur != null) && (next != null)) {
	        // swap values in cur and next
	        int tmp = cur.val;
	        cur.val = next.val;
	        next.val = tmp;
	        // move the pointers
	        cur = next.next;
	        if (cur != null)
	            next = cur.next;
	    }
	    return head;
	}
}
