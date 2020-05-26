package com.liang.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大层内元素和
 *
 * @author LiaNg
 * @date 2020/5/26 10:32
 */
public class L1161 {

    /**
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     *  
     * 示例：
     * 输入：[1,7,0,7,-8,null,null]
     * 输出：2
     * 解释：
     * 第 1 层各元素之和为 1，
     * 第 2 层各元素之和为 7 + 0 = 7，
     * 第 3 层各元素之和为 7 + -8 = -1，
     * 所以我们返回第 2 层的层号，它的层内元素之和最大。
     *  
     * 提示：
     * 树中的节点数介于 1 和 10^4 之间
     * -10^5 <= node.val <= 10^5
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<List<Integer>> list = new ArrayList<>();

        getVal(root, list, 0);

        int min = root.val;
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer sum = list.get(i).stream().reduce(Integer::sum).orElse(0);
            if (sum < min) {
                min = sum;
                index = i;
            }
        }

        return index + 1;
    }

    public void getVal(TreeNode node, List<List<Integer>> list, int k) {

        if (node == null) {
            return;
        }

        if (list.size() == k) {
            List<Integer> currList = new ArrayList<>();
            currList.add(node.val);
            list.add(currList);
        } else {
            list.get(k).add(node.val);
        }

        getVal(node.left, list, k + 1);
        getVal(node.right, list, k + 1);
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
