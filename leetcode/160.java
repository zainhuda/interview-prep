/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // get lengths of the lists
        ListNode node = headA;
        int aCount = 0, bCount = 0;
        while (node != null) {
            aCount++;
            node = node.next;
        }
        node = headB;
        while (node != null) {
            bCount++;
            node =  node.next;
        }
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (bCount >= aCount) {
            while (bCount != aCount) {
                nodeB = nodeB.next;
                bCount--;
            }
        } else {
            while (bCount != aCount) {
                nodeA = nodeA.next;
                aCount--;
            }
        }
        
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return null;
        
    }
}