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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // bfs 
        // we can use a queue, 
        Queue<TreeNode> store = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        store.add(root);
        while (!store.isEmpty()) {
            int level = store.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (store.peek().left != null) store.add(store.peek().left);
                if (store.peek().right != null) store.add(store.peek().right);
                temp.add(store.remove().val);
            }
            res.add(temp);
        }
        return res;
    }
}