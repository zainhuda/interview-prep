class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode node = head, prev = null;
        while (node != null) {
            // base case
            if (node.val == val && prev == null) {
                head = node.next;
                node = head;
                continue;
            } else if (node.val == val && prev != null) {
                prev.next = node.next;
                node = prev.next;
                continue;
            }
            prev = node;
            node = node.next;
        }
        return head;
    }
}
