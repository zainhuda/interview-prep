/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // two pointers
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0 == head.val ? 1 : 0);
        ListNode prev = dummy;
        ListNode curr = head;
        
        ListNode newlist = dummy;
        while (curr != null && curr.next != null) {
            if (prev.val != curr.val && curr.val != curr.next.val) {
                newlist.next = curr;
                newlist = newlist.next;
            }
            prev = curr;
            curr = curr.next;
        }
        
        if (curr.val != prev.val) {
            newlist.next = curr;
            newlist = newlist.next;
        }
        
        newlist.next = null;
        
        return dummy.next;
        
    }
}