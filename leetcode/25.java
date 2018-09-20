class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode start = dummy;
        while(true) {
            ListNode p = start, c, n = p;
            start = p.next;
            for(int i = 0; i < k && n != null; i++) n = n.next;
            if (n == null) break;
            for(int i = 0; i < k-1; i++) {
                c = p.next;
                p.next = c.next;
                c.next = n.next;
                n.next = c;
            }
        }
        return dummy.next;
    }
}