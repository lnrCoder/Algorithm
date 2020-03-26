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

    /**
     * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
     * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
     * 如果有多种构造方法，请你返回任意一种。
     *  
     * 提示：
     * 树节点的数目在 1 到 10^4 之间。
     * 树节点的值互不相同，且在 1 到 10^5 之间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
