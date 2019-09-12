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
    public int kthSmallest(TreeNode root, int k) {
        // we could use a heap of size k, and continiously add elements to it
        // can in order traversal and build an array of in order, which builds a sorted array
        // and then we just k-1 it 
        // O(n) time and O(n) space
        // iterative traversal
        // another thought, we can just short circuit it at k, so we don't need an array list to be built!
        if (root == null) return 0;
        Deque<TreeNode> store = new ArrayDeque<>();
        while (root != null) {
            store.push(root);
            root = root.left;
        }
        
        
        while (!store.isEmpty()) {
            TreeNode curr = store.pop();
            if (--k == 0) return curr.val;
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    store.push(curr);
                    curr = curr.left;
                }
            }
        }
    }
}