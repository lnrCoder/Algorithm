package com.liang.leetcode.tree;

/**
 * @ClassName: L700
 * @Description: 二叉搜索树中的搜索
 * @Author: LiaNg
 * @Date: 2020/1/29 18:04
 */
public class L700 {

    /**
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
