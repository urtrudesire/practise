package Code;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTreeTraversal {
    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null){
            return res;
        }
        List<TreeNode> levelList = new ArrayList<>();
        List<Integer> levelData = new ArrayList<>();
        levelList.add(root);
        levelData.add(root.val);

        res.add(levelData);
        List<TreeNode> tempNodes = new ArrayList<>();
        while(!levelList.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            levelList.forEach(x -> {
                addToList(x.left, tempList, tempNodes);
                addToList(x.right, tempList, tempNodes);
            });
            if (!tempList.isEmpty()){
                res.add(tempList);
            }
            levelList.clear();
            levelList.addAll(tempNodes);
            tempNodes.clear();
        }
        return res;
    }

    private void addToList(TreeNode node, List<Integer> list, List<TreeNode> nodes){
        if(node != null){
            list.add(node.val);
            nodes.add(node);
        }
    }
}
