/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // O(n) we go through the linkedlist and remove as we see the value
        if (head == null || (head.val == val && head.next == null)) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}