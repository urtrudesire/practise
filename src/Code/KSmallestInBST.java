package Code;

import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestInBST {

    /**
     * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     */

    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        fillQueue(root, queue);
        int res = 0;
        while(k > 0){
            res = queue.poll();
            k--;
        }
        return res;
    }

    private void fillQueue(TreeNode root, Queue<Integer> queue) {
        if(root == null){
            return;
        }
        fillQueue(root.left, queue);
        queue.add(root.val);
        fillQueue(root.right, queue);
    }
}
