package com.liang.leetcode.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L1382
 * @Description: 将二叉搜索树变平衡
 * @Author: LiaNg
 * @Date: 2020/3/26 13:14
 */
public class L1382 {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int l = 0, r = list.size() - 1;
        return build(list, l, r);
    }

    public TreeNode build(List<Integer> list, int l, int r) {

        if (l > r) {
            return null;
        }

        int m = l + (r - l) / 2;

        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, l, m - 1);
        root.right = build(list, m + 1, r);

        return root;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
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
