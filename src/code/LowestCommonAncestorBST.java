package code;

public class LowestCommonAncestorBST {

    /**
     *Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return iterateTree(root, max, min);
    }

    private TreeNode iterateTree(TreeNode root, int max, int min) {
        if( root.val >= min && root.val <= max){
            return root;
        }
        if(root.val > max){
            return iterateTree(root.left, max, min);
        } else {
            return iterateTree(root.right, max, min);
        }
    }
}
