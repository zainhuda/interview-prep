/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        // BFS
        // use a visited hashset to make sure we dont repeat nodes! 
        // we will use a queue
        // can use a hashmap to keep track of new nodes 
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            visited.add(curr);
            map.putIfAbsent(curr.val, new Node(curr.val, new ArrayList<>()));
            for (Node neighbor : curr.neighbors) {
                map.putIfAbsent(neighbor.label, new Node(neighbor.val, new ArrayList<>()));
                map.get(curr.val).neighbors.add(map.get(neighbor.val));
                if (!visited.contains(neighbor)) queue.add(neighbor);
            }
        }
        return map.get(node.val);
    }
}