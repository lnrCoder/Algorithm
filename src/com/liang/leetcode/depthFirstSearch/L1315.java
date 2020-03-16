package com.liang.leetcode.depthFirstSearch;

/**
 * @ClassName: L1315
 * @Description: 祖父节点值为偶数的节点和
 * @Author: LiaNg
 * @Date: 2020/3/16 22:28
 */
public class L1315 {

    int res;

    /**
     * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
     * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
     * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
     *  
     * 提示：
     * 树中节点的数目在 1 到 10^4 之间。
     * 每个节点的值在 1 到 100 之间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int sumEvenGrandparent(TreeNode root) {
        res = 0;
        helper(null, null, root);
        return res;
    }

    private void helper(TreeNode grandP, TreeNode father, TreeNode node) {
        if (node == null) {
            return;
        }

        if (grandP != null && grandP.val % 2 == 0) {
            res += node.val;
        }

        helper(father, node, node.left);
        helper(father, node, node.right);
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
