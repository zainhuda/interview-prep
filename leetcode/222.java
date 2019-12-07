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
    public int countNodes(TreeNode root) {
        // we do a bsearch lol this is wild 
        if (root == null) return 0;
        int d = depth(root);
        if (d == 0) return 1;
        
        // we do bsearch now
        int low = 1, high = (int)Math.pow(2, d)-1;
        while (low <= high)  {
            int mid = low + (high-low)/2;
            if (check(root, mid, d)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return (int)Math.pow(2,d)-1 + low;
    }
    
    public boolean check(TreeNode node, int key, int d) {
        int low = 0, high = (int)Math.pow(2, d)-1;
        // for each level of depth
        for (int i = 0; i < d; ++i) {
            int mid = low + (high-low)/2;
            if (mid >= key) {
                node = node.left;
                high = mid;
            } else {
                low = mid+1;
                node = node.right;
            }
        }
        return node != null;
    }
    
    public int depth(TreeNode root) {
        int d = 0;
        while (root.left != null) {
            root = root.left;
            d++;
        }
        return d;
    }
}