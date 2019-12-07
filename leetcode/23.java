/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // heap optimization
        // Nlogk
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) heap.offer(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = new ListNode(-1);
        dummy.next = node;
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            node.next = new ListNode(curr.val);
            node = node.next;
            if (curr.next != null) heap.offer(curr.next);
        }
        
        return dummy.next.next;
    }
}