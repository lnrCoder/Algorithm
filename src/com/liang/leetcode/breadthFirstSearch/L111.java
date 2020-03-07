package com.liang.leetcode.breadthFirstSearch;

/**
 * @ClassName: L111
 * @Description: 二叉树的最小深度
 * @Author: LiaNg
 * @Date: 2020/3/7 22:46
 */
public class L111 {

    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return bfs(root, 1);
    }

    public int bfs(TreeNode node, int k) {

        int result = Integer.MAX_VALUE;
        if (node.left == null && node.right == null) {
            return k;
        }
        if (node.left != null) {
            result = Math.min(result, bfs(node.left, k + 1));
        }
        if (node.right != null) {
            result = Math.min(result, bfs(node.right, k + 1));
        }
        return result;
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
