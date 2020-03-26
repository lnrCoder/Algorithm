package com.liang.leetcode.binarySearchTree;

/**
 * @ClassName: L1038
 * @Description: 从二叉搜索树到更大和树
 * @Author: LiaNg
 * @Date: 2020/3/26 12:51
 */
public class L1038 {

    int preNum = 0;

    /**
     * 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * 提醒一下，二叉搜索树满足下列约束条件：
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * 提示：
     * 树中的节点数介于 1 和 100 之间。
     * 每个节点的值介于 0 和 100 之间。
     * 给定的树为二叉搜索树。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode bstToGst(TreeNode root) {

        traverse(root);

        return root;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.right);
        node.val += preNum;
        preNum = node.val;

        traverse(node.left);
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
