/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    if (n <= m)
	        return a;
	    ListNode tmp = a;
	    int i = 1;
	    ListNode start = null;
	    ListNode end = null;
	    ListNode before_start = null;
	    while (tmp != null) {
	        if (i == m-1)
	            before_start = tmp;
	        if (i == m)
	            start = tmp;
	        if (i == n) {
	            end = tmp;
	            break;
	        }
	        tmp = tmp.next;
	        i++;
	    }
	   // System.out.println("start = " + start.val);
	   // System.out.println("end = " + end.val);
	    ListNode cur, prev;
	    prev = null;
	    cur = start;
	    while (cur != end) {
	        tmp = cur.next;
	        cur.next = prev;
	        prev = cur;
	        cur = tmp;
	    }
	   // System.out.println("cur = " + cur.val);
	    tmp = cur.next;
	    cur.next = prev; 
	    // point the node before start to cur
	    if (before_start != null) {
	       // System.out.println("before_start = " + before_start.val);
	        before_start.next = end;
	    } else {
	        a = end;
	    }
	    // point the node after cur to start
	    if (tmp != null) {
	       // System.out.println("cur->next = " + tmp.val);
	        start.next = tmp;
	    }
	    return a;
	}
}
