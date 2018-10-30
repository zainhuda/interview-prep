/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // We do this in BFS manner
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }
    public String serializeHelper(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = serializeHelper(root.left, str);
            str = serializeHelper(root.right, str);
        }
        return str;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> lldata = new LinkedList<String>();
        lldata.addAll(Arrays.asList(dataArray));
        return deserializeHelper(lldata);
    }
    public TreeNode deserializeHelper(List<String> data) {
        String val = data.remove(0);
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = deserializeHelper(data);
            root.right = deserializeHelper(data);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
