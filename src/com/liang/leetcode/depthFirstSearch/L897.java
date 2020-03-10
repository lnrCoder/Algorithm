package com.liang.leetcode.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L897
 * @Description: 递增顺序查找树
 * @Author: LiaNg
 * @Date: 2020/3/10 20:14
 */
public class L897 {

    List<Integer> vals = new ArrayList<>();

    /**
     * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        dfs(root, vals);
        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;

        for (Integer val : vals) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return ans.right;
    }

    public void dfs(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
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
