package com.liang.leetcode.breadthFirstSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: L993
 * @Description: 二叉树的堂兄弟节点
 * @Author: LiaNg
 * @Date: 2020/3/5 15:59
 */
public class L993 {

    /**
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
     * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null || root.val == x || root.val == y) {
            return false;
        }

        Map<Integer, Integer[]> map = new HashMap<>();

        bfs(root, map, 0);

        return !map.get(x)[0].equals(map.get(y)[0]) && map.get(x)[1].equals(map.get(y)[1]);
    }

    public void bfs(TreeNode node, Map<Integer, Integer[]> map, int k) {

        if (node.left != null) {
            map.put(node.left.val, new Integer[]{node.val, k});
            bfs(node.left, map, k + 1);
        }
        if (node.right != null) {
            map.put(node.right.val, new Integer[]{node.val, k});
            bfs(node.right, map, k + 1);
        }
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
