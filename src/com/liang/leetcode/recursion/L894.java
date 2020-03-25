package com.liang.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L894
 * @Description: 所有可能的满二叉树
 * @Author: LiaNg
 * @Date: 2020/3/25 12:10
 */
public class L894 {

    public static void main(String[] args) {
        L894 l894 = new L894();
        int N = 7;
        System.out.println("l894.allPossibleFBT(N) = " + l894.allPossibleFBT(N));
    }

    /**
     * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
     * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
     * 答案中每个树的每个结点都必须有 node.val=0。
     * 你可以按任何顺序返回树的最终列表。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<TreeNode> allPossibleFBT(int N) {
        if ((N & 1) == 0) {
            return new ArrayList<>();
        }

        return buildTree(N);
    }

    private List<TreeNode> buildTree(int N) {
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        N--;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= N / 2; i = i + 2) {
            List<TreeNode> tree1 = buildTree(i);
            List<TreeNode> tree2 = buildTree(N - i);

            for (TreeNode left : tree1) {
                for (TreeNode right : tree2) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    list.add(root);

                    if (i == N - i) {
                        continue;
                    }
                    root = new TreeNode(0);
                    root.left = right;
                    root.right = left;
                    list.add(root);
                }
            }
        }

        return list;
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
