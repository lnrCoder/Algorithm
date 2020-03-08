package com.liang.leetcode.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L102
 * @Description: 二叉树的层次遍历
 * @Author: LiaNg
 * @Date: 2020/3/8 21:46
 */
public class L102 {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(0, root);
        return result;
    }

    public void bfs(int k, TreeNode node) {
        if (node == null) {
            return;
        }

        if (result.size() <= k) {
            result.add(new ArrayList<>());
        }
        result.get(k).add(node.val);

        bfs(k + 1, node.left);
        bfs(k + 1, node.right);
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
