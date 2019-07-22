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
    // height calculator, but as we recrusively go back up, we check for height requirements, if diff > 1 then it's false
    public boolean isBalanced(TreeNode root) {
        return heightCheck(root) != -1;
    }
    
    public int heightCheck(TreeNode root) {
        if (root ==  null) {
            return 0;
        } 
        int leftHeight = heightCheck(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = heightCheck(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight-rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight)+1;
        
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 057ad22ceac16aebd14767902e9f7dd8cca343e1
