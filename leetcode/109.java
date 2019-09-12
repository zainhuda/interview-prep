/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // re cursion from middle out will help us build this tree
        List<Integer> store = new ArrayList<>();
        while (head != null) {
            store.add(head.val);
            head = head.next;
        }
        
        return convertListToBST(store, 0, store.size()-1);
        
    }
    
    public TreeNode convertListToBST(List<Integer> store, int left,  int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(store.get(mid));
        if (left == right) return node;
        node.left = convertListToBST(store, left, mid-1);
        node.right = convertListToBST(store, mid+1,right);
        
        return node;
        
    }
}