package com.liang.leetcode.tree;

/**
 * @ClassName: L104
 * @Description: 二叉树的最大深度
 * @Author: LiaNg
 * @Date: 2020/1/29 17:31
 */
public class L104 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
