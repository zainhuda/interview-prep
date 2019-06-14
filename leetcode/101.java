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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return check(root.left, root.right);
    }
    
    public boolean check(TreeNode left, TreeNode right) {
        // null check
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        
        // val check
        if (left.val == right.val) {
            return (check(left.left, right.right) && check(left.right, right.left));
        } else {
            return false;
        }
    }
}