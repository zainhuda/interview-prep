/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /*
 O(kN) k = number of lists
 O(1) space
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = null;
        for (int i = 0; i < lists.length; i++) {
            dummy = merger(dummy, lists[i]);
        }
        return dummy;
    }
    // built off the question of sorting 2 linkedlists
    public ListNode merger(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        if (l1 == null) {
            dummy.next = l2;
        }
        if (l2 == null) {
            dummy.next = l1;
        }
        return head.next;
    }
}
