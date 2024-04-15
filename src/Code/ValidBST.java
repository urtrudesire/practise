package Code;

public class ValidBST {

    /**
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     *
     * A valid BST is defined as follows:
     *
     * The left
     * subtree
     *  of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     */

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return isBst(root.left, Long.MIN_VALUE, root.val) && isBst(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isBst(TreeNode root, long min, long max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isBst(root.left, min, root.val) && isBst(root.right, root.val, max);
    }
}
