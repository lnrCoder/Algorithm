package com.liang.leetcode.tree;

/**
 * @ClassName: L226
 * @Description: 翻转二叉树
 * @Author: LiaNg
 * @Date: 2020/1/29 17:19
 */
public class L226 {

    /**
     * 翻转一棵二叉树。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
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
