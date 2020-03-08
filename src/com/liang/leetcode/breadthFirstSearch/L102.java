package com.liang.leetcode.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L102
 * @Description: 二叉树的层次遍历
 * @Author: LiaNg
 * @Date: 2020/3/8 21:46
 */
public class L102 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(0, root);
        return result;
    }

    public void bfs(int k, TreeNode node) {
        if (node == null) {
            return;
        }

        if (result.size() <= k) {
            result.add(new ArrayList<>());
        }
        result.get(k).add(node.val);

        bfs(k + 1, node.left);
        bfs(k + 1, node.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
