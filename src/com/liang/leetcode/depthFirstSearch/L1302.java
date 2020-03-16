package com.liang.leetcode.depthFirstSearch;

/**
 * @ClassName: L1302
 * @Description: 层数最深叶子节点的和
 * @Author: LiaNg
 * @Date: 2020/3/16 21:55
 */
public class L1302 {

    int maxDep = -1;
    int total = 0;

    /**
     * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
     * 提示：
     * 树中节点数目在 1 到 10^4 之间。
     * 每个节点的值在 1 到 100 之间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int deepestLeavesSum(TreeNode root) {

        dfs(root, 0);

        return total;
    }

    public void dfs(TreeNode node, int dep) {
        if (node == null) {
            return;
        }

        if (maxDep < dep) {
            maxDep = dep;
            total = node.val;
        } else if (maxDep == dep) {
            total += node.val;
        }

        dfs(node.left, dep + 1);
        dfs(node.right, dep + 1);
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
