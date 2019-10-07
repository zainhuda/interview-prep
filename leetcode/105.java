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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // we build the tree recursively 
        return builder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode builder(int[] preOrder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preOrder[preStart]);
        int inOrderRoot = preStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                inOrderRoot = i;
                break;
            }
        }
        int leftTreeLen = inOrderRoot - inStart;
        node.left = builder(preOrder, preStart+1, preStart+leftTreeLen, inorder, inStart, inOrderRoot-1);
        node.right = builder(preOrder, preStart+leftTreeLen+1, preEnd, inorder, inOrderRoot+1, inEnd);
        return node;
    }
}