package com.liang.leetcode.tree;

/**
 * @ClassName: L965
 * @Description: 单值二叉树
 * @Author: LiaNg
 * @Date: 2020/2/5 18:04
 */
public class L965 {

    public boolean isUnivalTree(TreeNode root) {
        boolean left = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left && right;
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
