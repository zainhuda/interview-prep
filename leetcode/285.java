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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        boolean found = false;
        TreeNode curr = root;
        while (curr != null || stack.size() != 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (found) return curr;
            if (curr.val == p.val) found = true;
            curr = curr.right;
        }
        return null;
    }
}
