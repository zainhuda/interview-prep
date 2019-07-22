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
    // LCA is the latest node that leads to nodes p and q
    // bottom up approach, can propogate a boolean value, when both subtrees return true, then we know we have found LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = new TreeNode(-1);
        lowestCommonAncestor(root, p, q, res);
        return res;
    }
    
    private boolean lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q, TreeNode res) {
        if (node == null) return false;
        
        int leftTree = lowestCommonAncestor(node.left, p, q, res) ? 1 : 0;
        int rightTree = lowestCommonAncestor(node.right, p, q, res) ? 1: 0;
        int currTree = (node.val == p.val || node.val == q.val) ? 1 : 0;
        
        if (leftTree + rightTree + currTree >= 2) res.val = node.val;
        
        return (leftTree + rightTree + currTree > 0);
        
    }
}
