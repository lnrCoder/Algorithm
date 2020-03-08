package com.liang.leetcode.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: L103
 * @Description: 二叉树的锯齿形层次遍历
 * @Author: LiaNg
 * @Date: 2020/3/8 22:19
 */
public class L103 {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        bfs(0, root);

        int index = 0;
        for (List<Integer> list : result) {
            if (index++ % 2 == 1) {
                Collections.reverse(list);
            }
        }

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
