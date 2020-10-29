package com.liang.leetcode.daily;

/**
 * 求根到叶子节点数字之和
 *
 * @author LiaNg
 * @date 2020/10/29 11:36
 */
public class L129 {

    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        getValue(root.val, root.left);
        getValue(root.val, root.right);

        return result;
    }

    private void getValue(int value, TreeNode node) {
        if (node == null) {
            return;
        }

        int curValue = value * 10 + node.val;

        if (node.right == null && node.left == null) {
            result += curValue;
        } else {
            getValue(curValue * 10 + node.val, node.left);
            getValue(curValue * 10 + node.val, node.right);
        }
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
