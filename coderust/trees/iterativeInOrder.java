class inorderIterative{
  static String inorder_iterative(BinaryTreeNode root)
  {
    String printR = "";
    Stack<BinaryTreeNode> stack = new Stack<>();
    BinaryTreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        node = node.left;
        continue;
      }
      BinaryTreeNode popped = stack.pop();
      printR += popped.data + ",";
      node = popped.right;
    }
    return printR;
  }
}
