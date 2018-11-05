/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// lots of help from
// https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem?page=2
class Solution {
    // dfs 2int array 0 -> root robbed 1 -> root not robbed
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2]; // [0,0]

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] result = new int[2];

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // don't rob root
        result[1] = root.val + left[0] + right[0]; // rob root

        return result;
    }
}
