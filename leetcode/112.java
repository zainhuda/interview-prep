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
    // recursively check both subtrees, propogate recurring total 
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return (search(root.left, sum, root.val) || search(root.right, sum, root.val));
    }
    
    public boolean search(TreeNode node, int sum, int currsum) {
        if (node == null) return false;
        currsum = currsum + node.val;
        if (currsum == sum && node.left == null && node.right == null) {
            return true;
        } 
        return (search(node.left, sum, currsum) || search(node.right, sum, currsum));
    }
}
