package Code;

public class SubTree {

    /**
     *Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     *
     * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
     */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        } else if(root == null || subRoot == null){
            return false;
        }

        boolean match = false;
        if(root.val == subRoot.val){
            match =  matchTree(root.left, subRoot.left) && matchTree(root.right, subRoot.right);
        }

        if(!match) {
            boolean left = isSubtree(root.left, subRoot);
            if (!left) {
                return isSubtree(root.right, subRoot);
            }
        }
        return true;
    }

    private boolean matchTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        } else if(root == null || subRoot == null){
            return false;
        }
        if(root.val == subRoot.val){
            return matchTree(root.left, subRoot.left) && matchTree(root.right, subRoot.right);
        }
        return false;
    }
}
