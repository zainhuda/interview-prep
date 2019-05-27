tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // Not the best answer 
        ListNode node = new ListNode(0);
        node = head;
        ArrayList store = new ArrayList<ListNode>();
        while (node != null) {
            store.add(node);
            node = node.next;
        }
        return (ListNode)store.get(store.size()/2);
    }
}
