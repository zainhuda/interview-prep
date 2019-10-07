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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // dfs
        // we can just recrusively build a string, once it's built we add it to our list
        dfs(root, new StringBuilder());
        return sum;
    }
    
    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            String num = sb.toString();
            System.out.println(num);
            sum += Integer.parseInt(num);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}