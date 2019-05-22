/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode curr = dummy.next.next;
      ListNode prev = dummy.next;
      while (curr != null) {
          if (curr.val == prev.val) {
              prev.next = curr.next;
              curr = prev.next;
          } else {
              curr = curr.next;
              prev = prev.next;
          }
      }
      return dummy.next;
  }
}