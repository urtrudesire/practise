package Code;

public class DiameterOfBT {

    /**
     * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
     * between two end nodes. The diagram below shows two trees each with diameter nine,
     * the leaves that form the ends of the longest path are shaded
     * (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
     */

    int result = Integer.MIN_VALUE;

    int diameter(TreeNode root) {
        // Your code here
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);

        int temp = Math.max(left, right) + 1;
        result = Math.max(result, left + right + 1);
        return temp;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        DiameterOfBT o = new DiameterOfBT();
        o.diameter(node);
        System.out.println(o.result);
    }
}
