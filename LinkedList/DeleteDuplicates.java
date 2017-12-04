/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    ListNode head = a;
	    ListNode cur = a;
	    if ((a == null) || (a.next == null))
	        return a;
	    ListNode next = a.next;
	    while (next != null) {
	        if (next.val == cur.val) {
	            next = next.next;
	            cur.next = next;
	        } else {
	            cur = next;
	            next = cur.next;
	        }
	    }
	    return a;
	}
}
