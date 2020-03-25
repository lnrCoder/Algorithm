package com.liang.leetcode.recursion;

/**
 * @ClassName: L687
 * @Description: 最长同值路径
 * @Author: LiaNg
 * @Date: 2020/3/25 19:27
 */
public class L687 {

    int result;

    /**
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     * 注意: 给定的二叉树不超过 10000 个结点。 树的高度不超过 1000。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-univalue-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestUnivaluePath(TreeNode root) {

        result = 0;

        getPath(root);

        return result;
    }

    public int getPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getPath(node.left);
        int right = getPath(node.right);

        int leftCount = 0, rightCount = 0;

        if (node.left != null && node.val == node.left.val) {
            leftCount += left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            rightCount += right + 1;
        }

        result = Math.min(result, leftCount + rightCount);

        return Math.max(leftCount, rightCount);
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
