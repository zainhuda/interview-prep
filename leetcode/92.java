class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy.next;
        for (int i = 1; i < m-1; i++) start = start.next;
        System.out.println(start.val);

        ListNode first = start.next;
        ListNode second = first.next;

        for (int i = 0; i<n-m; i++) {
            first.next = second.next;
            second.next = start.next;
            start.next = second;
            second = first.next;
        }

        return dummy.next;
    }
}
