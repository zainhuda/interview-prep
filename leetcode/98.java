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
   public boolean isValidBST(TreeNode root) {
       // edge case checking
       if (root == null) return true;
       if (root.left == null && root.right == null) return true;
       ArrayList<Integer> list = new ArrayList<>();
       inOrder(root, list);
       boolean check = true;
       // check if array is strictly increasing
       for (int i = 1; i < list.size(); i++) {
           if (list.get(i-1) >= list.get(i)) {
               check = false;
               break;
           }
       }

       return check;
   }
   public void inOrder(TreeNode node, ArrayList<Integer> list) {
       if (node == null) return;
       inOrder(node.left, list);
       list.add(node.val);
       inOrder(node.right, list);

   }
}
