class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create a new linked list
        ListNode dummy = new ListNode(0); // dummy node
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int value = l1.val + l2.val;
                if (carry == 1) {
                    carry--;
                    value++;
                }
                if (value > 9) {
                    value = Math.abs(10 - value);
                    carry++;
                }
                ListNode newZero = new ListNode(value);
                temp.next = newZero;
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            if (l1 == null) {
                int value =  l2.val;
                if (carry == 1) {
                    value++;
                    carry--;
                }
                if (value > 9) {
                    value = 0;
                    carry++;
                }
                ListNode newOne = new ListNode(value);
                temp.next = newOne;
                temp = temp.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                int value =  l1.val;
                if (carry == 1) {
                    value++;
                    carry--;
                }
                if (value > 9) {
                    value = 0;
                    carry++;
                }
                ListNode newTwo = new ListNode(value);
                temp.next = newTwo;
                temp = temp.next;
                l1 = l1.next;
                continue;
            }
        }
        if (carry == 1) {
                ListNode newThree = new ListNode(1);
                temp.next = newThree;
        }
        return dummy.next;
    }
}
