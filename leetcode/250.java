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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // recursive solution
        if (root == null) return 0;
        counter(root);
        return count;
    }
    
    public boolean counter(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        
        boolean unival = true;
        if (node.left != null) {
            unival = counter(node.left) && unival && node.left.val == node.val;
        }
        
        if (node.right != null) {
            unival = counter(node.right) && unival && node.right.val == node.val;
        }
        
        if (!unival) return false;
        count++;
        return true;
    }
}