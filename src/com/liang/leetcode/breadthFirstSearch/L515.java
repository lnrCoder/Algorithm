package com.liang.leetcode.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L515
 * @Description: 在每个树行中找最大值
 * @Author: LiaNg
 * @Date: 2020/3/9 0:15
 */
public class L515 {

    List<Integer> result = new ArrayList<>();

    /**
     * 您需要在二叉树的每一行中找到最大的值。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> largestValues(TreeNode root) {

        bfs(root, 0);
        return result;
    }

    public void bfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        if (result.size() == k) {
            result.add(node.val);
        } else {
            if (result.get(k) < node.val) {
                result.set(k, node.val);
            }
        }

        bfs(node.left, k + 1);
        bfs(node.right, k + 1);
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