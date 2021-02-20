package com.liang.leetcode.daily.history;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author LiaNg
 * @date 2020/5/22 9:48
 */
public class L105 {

    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pl, int pr, int il, int ir) {

        if (pl > pr) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pl]);

        int inOrderRoot = inOrderIndexMap.get(preorder[pl]);
        int size = inOrderRoot - il;

        node.left = build(preorder, pl + 1, pl + size, il, inOrderRoot - 1);
        node.right = build(preorder, pl + size + 1, pr, inOrderRoot + 1, ir);

        return node;
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
