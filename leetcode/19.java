/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // one pass with two pointers, n+1 ahead
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode back = dummy, front = dummy;
        dummy.next = head;
        if (head == null) return null;
        for (int i = 0; i <= n; i++) {
            front = front.next;
        }
        while (front != null) {
            back = back.next;
            front = front.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
