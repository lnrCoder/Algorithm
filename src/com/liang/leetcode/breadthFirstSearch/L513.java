package com.liang.leetcode.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: L513
 * @Description: 找树左下角的值
 * @Author: LiaNg
 * @Date: 2020/3/7 23:20
 */
public class L513 {

    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     * 注意: 您可以假设树（即给定的根节点）不为 NULL。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }

        return root.val;
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
