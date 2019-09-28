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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (K < 0 || target == null || root == null) return result;
        Map<TreeNode, ArrayList<TreeNode>> graph = new HashMap<>();
        buildGraph(graph, root, null);
        if (!graph.containsKey(target)) return result;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().val);
                }
                return result;
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                for (TreeNode neighbor : graph.get(curr)) {
                    if (visited.contains(neighbor)) continue;
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            K--;
        }
        return new ArrayList<Integer>();
    }
    
    private void buildGraph(Map<TreeNode, ArrayList<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<TreeNode>());
            if (parent != null) {
                graph.get(parent).add(node);
                graph.get(node).add(parent);
            }
            buildGraph(graph, node.left, node);
            buildGraph(graph, node.right, node);
        }
    }
}