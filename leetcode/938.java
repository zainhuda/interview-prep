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
    int c;
    public int rangeSumBST(TreeNode root, int L, int R) {
        c = 0;
        count(root, L, R);
        return c;
    }
    
    public void count(TreeNode node, int L, int R) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                c += node.val;
            }
            if (node.val > L) {
                count(node.left, L, R);
            }
            if (node.val < R) {
                count(node.right, L, R);
            }
        }
    }
}
