package com.liang.leetcode.breadthFirstSearch;

/**
 * @ClassName: L101
 * @Description: 对称二叉树
 * @Author: LiaNg
 * @Date: 2020/3/7 22:24
 */
public class L101 {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return bfs(root.left, root.right);
    }

    public boolean bfs(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && bfs(left.right, right.left) && bfs(left.left, right.right);
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
