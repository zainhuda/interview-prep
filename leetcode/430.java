/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        // we each time we encounter a child, we can reduce "flatten" it by one level
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node next = node.next;
                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;
                
                while (node.next != null) {
                    node = node.next;
                }
                if (next != null) {
                    node.next = next;
                    node.next.prev = node;
                }
            }
            node = node.next;
        }
        return head;
    }
}