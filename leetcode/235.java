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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA is the node that has p or q or both as it's 
        // iterate through the tree until p or q is found, or a parent to p or q
        // find split point! that's the LCA
        if (root.left == null && root.right == null) return root;
        TreeNode node = root;
        while (node != null) {
            if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else  {
                return node;
            }
        }
        return null;
    }
}