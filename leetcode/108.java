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
    // start at mid point and recursively add to the tree
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return treeBuilder(nums, 0, nums.length-1);
    }
    
    public TreeNode treeBuilder(int[] nums, int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = (min+max)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = treeBuilder(nums, min, mid-1);
        node.right = treeBuilder(nums, mid+1, max);
        return node;
    }
}