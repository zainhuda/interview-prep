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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // we just recursively do this
        // O(n) time -- O(h) space
        sumCalc(root);
        return maxSum;
    }
    
    public int sumCalc(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(0, sumCalc(root.left));
        int right = Math.max(0, sumCalc(root.right));
        
        int maxPath = left + right + root.val;
        maxSum = Math.max(maxPath, maxSum);
        
        return root.val + Math.max(left, right);
    }
}