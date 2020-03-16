package com.liang.leetcode.depthFirstSearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: L112
 * @Description: 路径总和
 * @Author: LiaNg
 * @Date: 2020/3/16 21:30
 */
public class L112 {

    Set<Integer> result = new HashSet<>();

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, 0);

        return result.contains(sum);
    }

    public void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(val + node.val);
        }
        dfs(node.left, val + node.val);
        dfs(node.right, val + node.val);
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
