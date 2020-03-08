package com.liang.leetcode.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L199
 * @Description: 二叉树的右视图
 * @Author: LiaNg
 * @Date: 2020/3/8 21:32
 */
public class L199 {

    List<Integer> result;

    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> rightSideView(TreeNode root) {

        result = new ArrayList<>();
        bfs(root, 0);
        return result;
    }

    public void bfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (result.size() == k) {
            result.add(node.val);
        }
        bfs(node.right, k + 1);
        bfs(node.left, k + 1);
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
