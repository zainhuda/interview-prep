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
    // similar to path sum 1
    // recursively build and propogate currsum, upon successful condition add to the result
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> curr = new ArrayList<>();
        if (root.val == sum && root.left == null && root.right == null) {
            curr.add(root.val);
            res.add(curr);
            return res;
        }
        recursiveBuild(root, new ArrayList(), res, 0, sum);
        return res;
    }
    
    public void recursiveBuild(TreeNode node, List<Integer> curr, List<List<Integer>> res, int currsum, int sum) {
        if (node == null) return;
        curr.add(node.val);
        currsum = currsum + node.val;
        if (currsum == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        } else if (currsum != sum && node.left == null && node.right == null) {
            curr.remove(curr.size()-1);
            return;
        }
        recursiveBuild(node.left, curr, res, currsum, sum);
        recursiveBuild(node.right, curr, res, currsum, sum);
        curr.remove(curr.size()-1);
    }
}
