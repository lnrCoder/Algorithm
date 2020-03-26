package com.liang.leetcode.binarySearchTree;

/**
 * @ClassName: MST1712
 * @Description: BiNode
 * @Author: LiaNg
 * @Date: 2020/3/26 13:40
 */
public class MST1712 {

    /**
     * 二叉树数据结构 TreeNode 可用来表示单向链表（其中 left 置空，right 为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
     * 返回转换后的单向链表的头节点。
     * 注意：本题相对原题稍作改动
     *  
     * 提示：
     * 节点数量不会超过 100000。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binode-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode convertBiNode(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(0);
        inorder(root, treeNode);

        return treeNode.right;
    }

    public TreeNode inorder(TreeNode root, TreeNode pre) {
        if (root != null) {
            pre = inorder(root.left, pre);
            root.left = null;
            pre.right = root;
            pre = root;
            pre = inorder(root.right, pre);
        }

        return pre;
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
