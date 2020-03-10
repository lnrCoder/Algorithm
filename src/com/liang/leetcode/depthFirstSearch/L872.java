package com.liang.leetcode.depthFirstSearch;

/**
 * @ClassName: L872
 * @Description: 叶子相似的树
 * @Author: LiaNg
 * @Date: 2020/3/10 19:03
 */
public class L872 {

    /**
     * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        String s1 = dfs(root1, "");
        String s2 = dfs(root2, "");

        return s1.equals(s2);
    }

    public String dfs(TreeNode node, String str) {

        if (node == null) {
            return str;
        }
        if (node.left == null && node.right == null) {
            return str + node.val;
        }

        return dfs(node.left, str) + dfs(node.right, str);
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
