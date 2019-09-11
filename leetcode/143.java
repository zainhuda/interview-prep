/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head ==  null || head.next == null) return;
        // find middle, reverse second half, and then add it in one by one
        ListNode start = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            start = start.next;
            fast = fast.next.next;
        }
        System.out.println(start.val);
        // start.next is the first node we use to reverse that part of the linkedlist
        ListNode hold = start;
        ListNode prev = null;
        start = start.next;
        while (start != null) {
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }
        
        // prev holds the start of the reversed linkedlist
        hold.next = prev;
        System.out.println(hold.next.val);
        // we begin swapping process
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p1 != hold) {
            hold.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = hold.next;
        }
    }
}