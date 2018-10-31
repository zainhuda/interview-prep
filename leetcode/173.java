/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// same thing as an inorder iterator
public class BSTIterator {
    Stack<TreeNode> nodeStack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            nodeStack.add(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode popped = nodeStack.pop();
        TreeNode node = popped.right;
        while (node != null) {
            nodeStack.add(node);
            node = node.left;
        }
        return popped.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
