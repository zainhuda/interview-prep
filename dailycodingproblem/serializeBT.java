// given the root of binary tree
// implement serialize(root)
// serializes the tree into a string,
// and deserialize(s) which deserializes the string back into the tree
// given the following node class
class Node {
  int val;
  Node left;
  Node right;
  public Node(int x) {
    this.val = x;
  }
}

class Solution {
  public String serialize(Node root) {
    // can do inorder traversal
    String returnS = "";
    returnS = serializeHelper(root, returnS);
    return returnS;
  }

  public String serializeHelper(Node node, String concat) {
    // recursively
    if (node == null) return;
    serializeHelper(node.left, concat);
    concat = concat + toChar(node.val); // concatenate string
    serializeHelper(node.right, concat);
  }

  public Node deserialize(String s) {

  }
  public static void main(String[] args) {

  }
}
