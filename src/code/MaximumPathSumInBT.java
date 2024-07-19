package code;

public class MaximumPathSumInBT {
    /**
     * Given a binary tree, the task is to find the maximum path sum.
     * The path may start and end at any node in the tree.
     */

    int result = Integer.MIN_VALUE;
    int solve(TreeNode node)
    {
        //your code goes here
        if(node == null){
            return 0;
        }
        int left = solve(node.left);
        int right = solve(node.right);

        int temp = Math.max(Math.max(Math.max(left, right), 0) + node.val, 0);
        result = Math.max(result, left + right + node.val);
        return temp;
    }

    public static void main(String[] args) {
        MaximumPathSumInBT o = new MaximumPathSumInBT();
        TreeNode l1 = new TreeNode(20);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode left = new TreeNode(2, l1, l2);
        TreeNode right = new TreeNode(-25, l3, l4);
        TreeNode root = new TreeNode(10, left, right);
        o.solve(root);
        System.out.println(o.result);
    }

}
