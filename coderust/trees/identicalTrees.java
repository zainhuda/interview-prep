class identicalTrees{
  public static boolean are_identical(BinaryTreeNode root1, BinaryTreeNode root2) {
    // recursively checking
    if (root1 == null && root2 == null) return true;
    if (root1 != null && root2 != null) {
      return ((root1.data == root2.data) && are_identical(root1.left, root2.left) && are_identical(root1.right, root2.right));
    }
    return false;
  }
}
