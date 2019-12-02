package com.liang.leetcode.recursion;

/**
 * @ClassName L938
 * @description 二叉搜索树的范围和
 * @Author LiaNg
 * @Date 2019-12-02
 */
public class L938 {

    /**
     * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
     * 二叉搜索树保证具有唯一的值。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }

        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
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
