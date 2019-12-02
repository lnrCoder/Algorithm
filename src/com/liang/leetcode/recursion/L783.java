package com.liang.leetcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName L783
 * @description 二叉搜索树结点最小距离
 * @Author LiaNg
 * @Date 2019-12-02
 */
public class L783 {

    List<Integer> numList;

    /**
     * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minDiffInBST(TreeNode root) {

        int min = Integer.MAX_VALUE;
        numList = new ArrayList<>();

        dfs(root);

        Collections.sort(numList);

        for (int i = 0; i < numList.size() - 1; i++) {
            min = Math.min(min, numList.get(i + 1) - numList.get(i));
        }

        return min;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        numList.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * LeetCode Java 耗时最短解答
     */
    public int minDiffInBST1(TreeNode root) {
        int res = Integer.MAX_VALUE;
        TreeNode last = null;
        while (root != null) {
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                    continue;
                } else {
                    prev.right = null;
                }
            }
            if (last != null) {
                res = Math.min(res, Math.abs(root.val - last.val));
            }
            last = root;
            root = root.right;
        }
        return res;
    }
}

