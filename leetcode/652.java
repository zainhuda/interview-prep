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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // we do a traversal of the tree, and we see each node, add it's tree to the 
        // hashmap
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map =  new HashMap<>();
        treeBuilder(root, map, result);
        return result;
    }
    
    private String treeBuilder(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) return "#";
        String tree = root.val + treeBuilder(root.left, map, result) + treeBuilder(root.right, map, result);
        map.put(tree, map.getOrDefault(tree, 0)+1);
        if (map.get(tree) == 2) result.add(root);
        return tree;
    }
}