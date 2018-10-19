class inorder_tree_iterator {
    Stack<BinaryTreeNode> stack = new Stack<>();
    public inorder_tree_iterator(BinaryTreeNode root) {
      // push all of left subtree
      BinaryTreeNode node = root;
      while(node != null) {
        stack.push(node);
        node = node.left;
      }
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }

    public BinaryTreeNode getNext() {
      if (stack.isEmpty()) return null;
      BinaryTreeNode right = stack.pop();
      // we push right node and all of the right nodes left subtree
      // on to the stack
      BinaryTreeNode iteratorNode = right.right;
      while (iteratorNode != null) {
        stack.push(iteratorNode);
        iteratorNode = iteratorNode.left;
      }
      return right;
    }

    //Don't Change anything down below
    public String inorder_using_iterator(BinaryTreeNode root) {
      inorder_tree_iterator iter = new inorder_tree_iterator(root);
      String result = "";
      while (iter.hasNext()) {
        result += iter.getNext().data + ",";
      }
      return result;
    }
}
