package com.liang.leetcode.depthFirstSearch;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: L257
 * @Description: 二叉树的所有路径
 * @Author: LiaNg
 * @Date: 2020/3/10 19:13
 */
public class L257 {

    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        dfs(root, "", paths);
        return paths;
    }

    public void dfs(TreeNode node, String str, List<String> paths) {

        if (node != null) {
            str += Integer.toString(node.val);
            if ((node.left == null) && (node.right == null)) {
                paths.add(str);
            } else {
                str += "->";
                dfs(node.left, str, paths);
                dfs(node.right, str, paths);
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
}
