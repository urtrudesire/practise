package code;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

    /**
     * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     * <p>
     * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
     * <p>
     * The encoded string should be as compact as possible.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [2,1,3]
     * Output: [2,1,3]
     * Example 2:
     * <p>
     * Input: root = []
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 104].
     * 0 <= Node.val <= 104
     * The input tree is guaranteed to be a binary search tree.
     */

    public static void main(String[] args) {
        SerializeAndDeserializeBST o = new SerializeAndDeserializeBST();
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(4);
        node.left = left;
        node.right = right;
        System.out.println(o.serialize(node));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.val).append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data || data.isEmpty()){
            return new TreeNode();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] stream = data.split(" ");
        TreeNode root = new TreeNode(stream[0]);
        queue.add(root);
        for (int i = 1; i < stream.length; i++) {
            TreeNode parent = queue.poll();
            assert parent != null;
            if(!stream[i].equals("n")){
                TreeNode left = new TreeNode(stream[i]);
                parent.left = left;
                queue.add(left);
            }
            i++;
            if(!stream[i].equals("n")){
                TreeNode right = new TreeNode(stream[i]);
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
