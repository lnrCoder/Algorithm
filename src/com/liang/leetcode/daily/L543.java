package com.liang.leetcode.daily;

/**
 * @ClassName: L543
 * @Description: 二叉树的直径 2020.3.10
 * @Author: LiaNg
 * @Date: 2020/3/10 20:28
 */
public class L543 {

    int max = 0;

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        nodeDiameter(root);
        return max;
    }

    public int nodeDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int thisMax = nodeDiameter(node.left) + nodeDiameter(node.right);

        max = Math.max(thisMax, max);

        return thisMax + 1;
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
