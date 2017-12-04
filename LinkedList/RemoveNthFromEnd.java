/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode a, int b) {
	    ListNode head = a;
	    int lengthOfList = 0;
	    while (a != null) {
	        lengthOfList++;
	        a = a.next;
	    }
	    if (lengthOfList == 0)
	        return head;
	    if (b > lengthOfList) {
	        head = head.next;
	        return head;
	    }
	    int elementToDelete = lengthOfList-b+1;
	    a = head;
	    int curElement = 0;
	    ListNode prev = null;
	    while (a != null) {
	        curElement++;
	        if (curElement == elementToDelete) {
	            ListNode next = a.next;
	            if (prev == null) {
	                // deleting head of list
	                head = a.next;
	            } else {
	                prev.next = a.next;
	                a = a.next;
	            }
	            break;
	        } else {
	            prev = a;
	            a = a.next;
	        }
	    }
	    return head;
	}
}
