/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> store = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (store.contains(node)) return true;
            store.add(node);
            node = node.next;
        }
        return false;

    }
}
